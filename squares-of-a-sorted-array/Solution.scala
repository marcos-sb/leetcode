object Solution {
  def sortedSquares(A: Array[Int]): Array[Int] = {
    A.map(n => n*n).sorted
  }
}