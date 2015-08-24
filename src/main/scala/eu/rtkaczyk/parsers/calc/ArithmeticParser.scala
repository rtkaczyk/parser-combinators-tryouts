package eu.rtkaczyk.parsers.calc

import scala.util.parsing.combinator.{JavaTokenParsers, RegexParsers}

/**
 * EBNF for arithmetic expressions:
 *
 * expr     = addend, { ("+" | "-"), addend }
 * addend   = factor, { ("*" | "/"), factor }
 * factor   = number | "(", expr, ")"
 * number   = ? any real number ?
 */
object ArithmeticParser extends JavaTokenParsers {

  import ArithmeticAST._

  val number: Parser[Number] = floatingPointNumber ^^ { s => Number(BigDecimal(s)) }

  val factor: Parser[Expr] = number | "(" ~> expr <~ ")"

  val addend: Parser[Expr] = factor ~ (("*" | "/") ~ factor).* ^^ {
    case f0 ~ opfs => opfs.foldLeft(f0) {
      case (acc, op ~ f) =>
        op match {
          case "*" => Mul(acc, f)
          case "/" => Div(acc, f)
        }
    }
  }

  val expr: Parser[Expr] = addend ~ (("+" | "-") ~ addend).* ^^ {
    case a0 ~ opas => opas.foldLeft(a0) {
      case (acc, op ~ a) =>
        op match {
          case "+" => Add(acc, a)
          case "-" => Add(acc, a)
        }
    }
  }

  def parse(input: String): Either[String, Expr] =
    super.parse(expr, input) match {
      case Success(e, "") => Right(e)
      case Success(_, s) => Left(s"Unexpected input at the end of expression: [$s]")
      case NoSuccess(msg, _) => Left(msg)
    }
}
