package calclexer

object IntCalculatorLexer {
  sealed trait Token
  case class Operator(value: Char) extends Token
  case class Integer(value: Int) extends Token

  def error(): Nothing = throw new Exception("Syntax error")

  def run(source: List[Char], acc: Vector[Token] = Vector()): Vector[Token] =
    ???
}
