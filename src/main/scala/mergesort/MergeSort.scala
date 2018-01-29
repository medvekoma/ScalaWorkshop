package mergesort

object MergeSort {

  def run(list: List[Int]): List[Int] = {
    sort(list)
  }

  def sort(list: List[Int]): List[Int] = {
    val (left, right) = split(list)
    left match {
      case Nil => list
      case _ => merge(sort(left), sort(right))
    }
  }

  def split(list: List[Int]): (List[Int], List[Int]) = {
    val half = list.length / 2
    list.splitAt(half)
  }

  def merge(list1: List[Int], list2: List[Int]): List[Int] = {
    (list1, list2) match {
      case (Nil, _) => list2
      case (_, Nil) => list1
      case (head1 :: tail1, head2 :: tail2) =>
        if (head1 < head2)
          head1 :: merge(tail1, list2)
        else
          head2 :: merge(list1, tail2)
    }
  }

}
