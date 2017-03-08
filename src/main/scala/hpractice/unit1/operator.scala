package hpractice
package unit1

object operator extends App {

  example("1") {
    1 + 1 == 2
  }

  example("2") {
    " 1 " + "1" == " 1 1"
  }

  example("3") {
    val x = 1 + 1
    // X is a value. Reassignment of x will cause an error.
    // The error will disappear after removing the reassignment statement.
    // x是一个常量（value），重新赋值将产生error
    // 删去下一行则error消失
    x = 3
    x == 2
  }

  example("4") {
    var x = 1 + 1
    // X is a variable. Reassignment of x will not cause an error.
    // x是一个变量，可以重新赋值
    x = 3
    x == 3
  }

  example("5") {
    var x: Int = 1 + 1
    // X is an integer. Reassignment a double value will cause an error.
    // The error will disappear after removing the reassignment statement.
    // x是一个类型为整数的变量，将其赋值为浮点型将产生error
    // 删去下一行则error消失
    x = 2.0
    x.isInstanceOf[Int]
  }

  example("6") {
    val x: Int = 1 + 1
    val y      = 1 + 1
    // X is a variable. Reassignment of x will not cause an error.
    // x, y均为整数类型，y没有显式声明变量类型，因为可以从右边推导出来
    x.isInstanceOf[Int] && y.isInstanceOf[Int]
  }
  
  question("1") {
    1 + 1 == ?
  }

  question("2") {
    var x = 2
    x = 10
    x == ?
  }

  question("3") {
    var x = 2
    x = 10
    x == ?
  }

  question("4") {
    val x = 2.0
    x.isInstanceOf[?]
  }

  question("5") {
    val x = "abcd"
    x.isInstanceOf[?]
  }

}