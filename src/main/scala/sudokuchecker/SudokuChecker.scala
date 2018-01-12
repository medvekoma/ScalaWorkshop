package sudokuchecker

object SudokuChecker {

  def run(grid: Array[Array[Char]]): Boolean = sudoku2(grid)

  def isLegal(nums: Seq[Char]): Boolean = {
    val noDots = nums.filter(_ != '.')
    noDots.length == noDots.distinct.length
  }

  def sudoku2(grid: Array[Array[Char]]): Boolean = {
    val squares: Seq[Seq[Char]] =
      for {
        i <- 0 to 2
        j <- 0 to 2
      } yield
        for {
          k <- 0 to 2
          l <- 0 to 2
        } yield grid(i * 3 + k)(j * 3 + l)

    (grid.map(_.toSeq) ++ grid.transpose.map(_.toSeq) ++ squares)
      .forall(isLegal)
  }

}
