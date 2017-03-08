import scalaj.http.Http
import better.files.File
import Console.{RESET, RED, GREEN}
import spray.json._
import DefaultJsonProtocol._

object SubmitUtils {

  val projectRoot = File("src\\main\\scala\\hpractice")

  def error(msg: String): Unit = {
    println(s"${RESET}${RED}[error] ${msg}${RESET}")
  }

  def success(msg: String): Unit = {
    println(s"${RESET}${GREEN}[success] ${msg}${RESET}") 
  }

  final case class Submit(name: String, unit: String, filename: String, content: String)

  implicit val submitFormat = jsonFormat4(Submit)

  def submit(name: String, unit: String, filename: String) = {
    val fn = filename + ".scala"
    val f = projectRoot / unit / fn
    if (f.notExists) {
      error(s"File at ${unit}\\${fn} doesn't exists. Please check.")
    } else {
      val data = Submit(name, unit, fn, f.contentAsString).toJson.prettyPrint
      val url = "http://www.hrcalender.pw/hpractice"
      val resp = Http(url).postData(data).header("content-type", "application/json").asString
      resp.code match {
        case 200 => success("Submit successly.")
        case _ => error(resp.body)
      }
    }
  }

}
