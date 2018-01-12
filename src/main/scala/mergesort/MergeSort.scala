package mergesort

object MergeSort {

  def run(list: List[Int]): List[Int] = {
    val n = list.length / 2
    if (n == 0) list
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case(Nil, ys) => ys
          case(xs, Nil) => xs
          case(x :: xs1, y :: ys1) =>
            if (x < y) x::merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (left, right) = list.splitAt(n)
      merge(run(left), run(right))
    }
  }

}
