import org.scalatest._
import prop._

class SumElementsSpec extends PropSpec with Matchers with PropertyChecks {

  property("Sum should return correct results") {
    forAll { (list: List[Int]) =>
      SumElements.run(list) should be(list.sum)
    }
  }

}
