import org.scalatest.{FlatSpec, Matchers}
import calclexer.IntCalculatorLexer
import calclexer.IntCalculatorLexer.Token

class IntCalculatorLexerSpec extends FlatSpec with Matchers {

  "SimpleTokenizer" should "work" in {

    val result =
      Vector(Token("1", "Int"), Token("+", "Operator"), Token("2", "Int"))

    val result2 =
      Vector(Token("123", "Int"), Token("+", "Operator"), Token("256", "Int"))

    assert(result == IntCalculatorLexer.run("1+2".toList))
    assert(result == IntCalculatorLexer.run("  1  +  2  ".toList))
    assert(
      result ++ Vector(Token("*", "Operator"),
                       Token("9", "Int"),
                       Token("-", "Operator"),
                       Token("2", "Int")) == IntCalculatorLexer.run(
        "  1  +  2 * 9 - 2  ".toList))

    assert(result2 == IntCalculatorLexer.run("123 + 256".toList))
  }

}
