import org.scalatest.{FlatSpec, Matchers}
import calclexer.IntCalculatorLexer
import calclexer.IntCalculatorLexer.{Integer, Operator}

class IntCalculatorLexerSpec extends FlatSpec with Matchers {

  val result =
    Vector(Integer(1), Operator('+'), Integer(2))

  val result3 = result ++ Vector(Operator('*'),
                                 Integer(9),
                                 Operator('-'),
                                 Integer(2))

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
      Vector(Integer(123), Operator('+'), Integer(256))

    assert(result2 == IntCalculatorLexer.run("123 + 256".toList))
  }

}
