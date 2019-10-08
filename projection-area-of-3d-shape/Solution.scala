object Solution {
  def projectionArea(grid: Array[Array[Int]]): Int = {
    val elements = grid.map(_.count(_ > 0)).sum
    val maxByRow = grid.map(_.max).sum
    val maxByCol = grid.transpose(n => n).map(_.max).sum
    elements + maxByRow + maxByCol
  }
}