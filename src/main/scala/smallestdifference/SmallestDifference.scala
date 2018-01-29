package smallestdifference

object SmallestDifference {

  def run(list: List[Int]): Option[Int] = {
    list.sorted
      .sliding(2).filter(_.size == 2)
      .map(item => item(1) - item.head)
      .reduceOption(_ min _)
  }

}
