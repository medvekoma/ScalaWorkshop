import org.scalatest.{FlatSpec, Matchers}
import calclexer.IntCalculatorLexer
import calclexer.IntCalculatorLexer.Token

class IntCalculatorLexerSpec extends FlatSpec with Matchers {

  val result =
    Vector(Token("1", "Int"), Token("+", "Operator"), Token("2", "Int"))

  val result3 = result ++ Vector(Token("*", "Operator"),
                                 Token("9", "Int"),
                                 Token("-", "Operator"),
                                 Token("2", "Int"))

  "SimpleTokenizer" should "process operators and single digit numbers" in {
    assert(result == IntCalculatorLexer.run("1+2".toList))
    assert(result3 == IntCalculatorLexer.run("1+2*9-2".toList))
  }

  it should "handle single whitespaces" in {
    assert(result == IntCalculatorLexer.run("1 +2 ".toList))
    assert(result3 == IntCalculatorLexer.run(" 1 + 2 * 9 - 2 ".toList))
  }

  it should "handle any number of whitespaces" in {
    assert(result == IntCalculatorLexer.run("1    +2 ".toList))
    assert(result3 == IntCalculatorLexer.run(" 1 + 2 * 9    - \n 2  ".toList))
  }

  it should "process integers with more than one digits" in {
    val result2 =
      Vector(Token("123", "Int"), Token("+", "Operator"), Token("256", "Int"))

    assert(result2 == IntCalculatorLexer.run("123 + 256".toList))
  }

}
