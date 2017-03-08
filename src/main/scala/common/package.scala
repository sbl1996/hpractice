package object common {
  
  type ? = Nothing

  def question(msg: String)(body: => Boolean): Unit = {
    if (!body) {
      val wrongAnswerPrefix = msg + "WRONG!!!"
      println(wrongAnswerPrefix + msg)
    }
  }

}