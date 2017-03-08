import Console.{GREEN, RED, RESET}

package object hpractice {
  
  object ?

  def wrong(msg: String): Unit = {
    Console.println(s"${RESET}${RED}${msg}${RESET}")
  }

  def right(msg: String): Unit = {
    Console.println(s"${RESET}${GREEN}${msg}${RESET}")
  }

  def question(msg: String)(body: => Boolean): Unit = {
    val isRight = body
    if (isRight) right("Question " + msg)
    else wrong("Question" + msg)
  }

  def example(msg: String)(body: => Boolean): Unit = {
    val isRight = body
    if (isRight) right("Example " + msg)
    else wrong("Example" + msg)
  }

}