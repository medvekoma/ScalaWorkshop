package smallestdifference

object SmallestDifference {

  def run(list: List[Int]): Option[Int] =
    if (list.length < 2) None
    else Some(list.sorted.sliding(2).map(x => x(1) - x(0)).min)

}
