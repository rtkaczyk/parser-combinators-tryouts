package eu.rtkaczyk.parsers.calc

import scala.io.StdIn

object Run extends App {
  val input = StdIn.readLine()

  ArithmeticParser.parse(input) match {
    case Right(expr) => println(expr.eval)
    case Left(msg) => print(msg)
  }
}
