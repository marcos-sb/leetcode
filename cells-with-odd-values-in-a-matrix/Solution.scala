object Solution {
  def oddCells(n: Int, m: Int, indices: Array[Array[Int]]): Int = {
    val mat = Array.fill(n,m)(0)
    for (index <- indices) {
      for (i <- 0 until m) {
        mat(index(0))(i) += 1
      }
      for (i <- 0 until n) {
        mat(i)(index(1)) += 1
      }
    }
    var odds = 0
    for (row <- mat; el <- row; if el % 2 == 1) {
      odds += 1
    }
    odds
  }
}