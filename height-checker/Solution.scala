object Solution {
  def heightChecker(heights: Array[Int]): Int = {
    val counts = Array.fill(101)(0)
    for (h <- heights) counts(h) += 1
    var k = 0
    var diff = 0
    for (i <- counts.indices)
      while (counts(i) > 0) {
        if (i != heights(k)) {
          diff += 1
        }
        counts(i) -= 1
        k += 1
      }
    diff
  }
}