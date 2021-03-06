import org.scalatest._
import prop._
import sumelements.SumElements

class SumElementsSpec extends PropSpec with Matchers with PropertyChecks {

  property("should return correct results") {
    forAll { (list: List[Int]) =>
      SumElements.run(list) should be(list.sum)
    }
  }

}
