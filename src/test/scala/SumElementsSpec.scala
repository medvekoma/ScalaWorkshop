import org.scalatest._
import org.scalacheck.Prop.forAll

class SumElementsSpec extends FlatSpec with Matchers {

  val prop = forAll { (list: List[Int]) =>
    SumElements.sumElements(list) == list.sum
  }

  prop.check
}
