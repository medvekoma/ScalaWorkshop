import mergesort.MergeSort
import org.scalatest._
import prop._

class MergeSortSpec extends PropSpec with Matchers with PropertyChecks {

  property("should return a sorted list") {
    forAll { (list: List[Int]) =>
      println(list)
      MergeSort.run(list) should be(list.sorted)
    }
  }

}
