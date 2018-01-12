package calclexer

object IntCalculatorLexer {
  sealed trait Token
  case class Operator(value: Char) extends Token
  case class Integer(value: Int) extends Token

  def error(): Nothing = throw new Exception("Syntax error")

  def run(source: List[Char], acc: Vector[Token] = Vector()): Vector[Token] =
    source match {
      case Nil => acc
      case head :: tail =>
        head match {
          case x if x.isDigit =>
            val numberString = (head :: tail.takeWhile(_.isDigit)).mkString
            run(tail.drop(numberString.length - 1), acc :+ Integer(numberString.toInt))

          case '+' | '-' | '*' | '/' =>
            run(tail, acc :+ Operator(head))

          case x if x.isWhitespace =>
            run(tail.dropWhile(_.isWhitespace), acc)
        }
    }
}
