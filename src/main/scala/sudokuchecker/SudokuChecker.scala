package sudokuchecker

object SudokuChecker {

  def isValid(block: Seq[Char]): Boolean = {
    val numbers = block.filter(_ != '.')

    numbers.lengthCompare(numbers.filter(('0' to '9').contains _).distinct.length) == 0
  }

  def run(grid: Array[Array[Char]]): Boolean = {
    if ((grid.length != 9) || grid.exists(row => row.length != 9))
      false
    else {
      val all = grid.map(_.toSeq) ++ grid.transpose.map(_.toSeq) ++ getBlocks(grid)

      all.forall(isValid)
    }
  }

  def getBlocks(grid: Array[Array[Char]]): Seq[Seq[Char]] = {
    for {
      ox <- 0 to 6 by 3
      oy <- 0 to 6 by 3
    } yield {
      for {
        x <- 0 to 2
        y <- 0 to 2
      } yield grid(ox + x)(oy + y)
    }
  }

}
