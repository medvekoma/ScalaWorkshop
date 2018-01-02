import org.scalatest._
import prop._

class MergeSortSpec extends PropSpec with Matchers with PropertyChecks {

  property("Merge sort should return a sorted list") {
    forAll { (list: List[Int]) =>
      MergeSort.run(list) should be(list.sorted)
    }
  }

}
