package calclexer

import scala.annotation.tailrec

object IntCalculatorLexer {
  sealed trait Token
  case class Operator(value: Char) extends Token
  case class Integer(value: Int) extends Token

  def error(): Nothing = throw new Exception("Syntax error")

  def run(source: String) : Vector[Token] = run(source.toList)

  @tailrec
  def run(source: List[Char], acc: Vector[Token] = Vector()): Vector[Token] = {

    source match {
      case Nil => acc
      case head :: tail if "+-*/".contains(head) => run(tail, acc :+ Operator(head))
      case head :: tail if head.isWhitespace => run(tail, acc)
      case head :: tail if head.isDigit => {
        val digits = source.takeWhile(_.isDigit).mkString
        run(tail.drop(digits.length - 1), acc :+ Integer(digits.toInt))
      }
      case _ => error()
    }
  }

}

