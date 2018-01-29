package sudokuchecker

object SudokuCheckerOld {

  def descartes[T](a: Seq[T], b: Seq[T]): Seq[(T, T)] = {
    a.flatMap(x => b.map(y => (x,y)))
  }

  def add(origin: (Int, Int), offsets: Seq[(Int, Int)]): Seq[(Int, Int)] = {
    offsets.map(offset => (origin._1 + offset._1, origin._2 + offset._2))
  }

  def isValid(block: Array[Char]): Boolean = {
    val numbers = block.filter(_ != '.')

    numbers.forall(('0' to '9').contains(_)) &&
      numbers.groupBy(x => x).forall(x => x._2.length == 1)
  }

  def run(grid: Array[Array[Char]]): Boolean = {
    if ((grid.length != 9) && (!grid.filter(row => row.length != 9).isEmpty))
      false
    else {
      val rows = grid
      val columns = (0 to 8).map(x => (0 to 8).map(grid(_)(x)).toArray).toArray

      val blockOrigins = descartes(0 to 6 by 3, 0 to 6 by 3)
      val blockOffsets = descartes(0 to 2, 0 to 2)
      val blocks = blockOrigins.map(origin => add(origin, blockOffsets))
        .map(seq => seq.map(cell => grid(cell._1)(cell._2)).toArray)

      val all = rows ++ columns ++ blocks

      all.forall(isValid)
    }
  }

}
