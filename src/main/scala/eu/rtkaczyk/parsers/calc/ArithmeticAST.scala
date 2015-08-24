package eu.rtkaczyk.parsers.calc

object ArithmeticAST {

  trait Expr {
    def eval: BigDecimal
  }

  case class Add(a: Expr, b: Expr) extends Expr {
    def eval = a.eval + b.eval
  }

  case class Sub(a: Expr, b: Expr) extends Expr {
    def eval = a.eval - b.eval
  }

  case class Mul(a: Expr, b: Expr) extends Expr {
    def eval = a.eval * b.eval
  }

  case class Div(a: Expr, b: Expr) extends Expr {
    def eval = a.eval / b.eval
  }

  case class Number(n: BigDecimal) extends Expr {
    def eval = n
  }

}
