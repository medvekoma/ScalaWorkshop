package calclexer

object IntCalculatorLexer {
  case class Token(content: String, `type`: String)

  def error(): Nothing = throw new Exception("Invalid Sequence")

  def run(source: List[Char], acc: Vector[Token] = Vector()): Vector[Token] = source match {
    case Nil => acc
    case head :: tail =>
      head match {
        case x if x.isDigit =>
          val number = (x :: tail.takeWhile(_.isDigit)).mkString
          run(tail.drop(number.length - 1), acc :+ Token(number, "Int"))

        case '+' | '-' | '*' | '/' =>
          run(tail, acc :+ Token(head.toString, "Operator"))

        case x if x.isWhitespace =>
          run(tail.dropWhile(_.isWhitespace), acc)

        case _ => error()
      }
  }
}
