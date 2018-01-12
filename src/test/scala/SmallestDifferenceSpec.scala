import org.scalatest._
import smallestdifference.SmallestDifference

class SmallestDifferenceSpec extends FlatSpec with Matchers {

  "SmallestDifference.run" should "return correct values for a list" in {
    val list  = List(1, 2, 5, 9, 12, 123, 1233)
    assert(SmallestDifference.run(list).get == 1)
  }

  it should "return None for empty lists" in {
    assert(SmallestDifference.run(List[Int]()).isEmpty)
  }

  it should "return None for lists with 1 element" in {
    assert(SmallestDifference.run(List(1)).isEmpty)
  }
}
