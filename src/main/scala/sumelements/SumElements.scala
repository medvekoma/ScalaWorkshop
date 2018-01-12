package sumelements

object SumElements {

  def run(list: List[Int]): Int = {
    list.fold(0)(_ + _)
  }

}
