object Solution {
  def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
    var lineWidth = 0
    var lines = 1
    for (c <- S) {
      val nextWidth = widths(c - 'a')
      lineWidth += nextWidth
      if (lineWidth > 100) {
        lines += 1
        lineWidth = nextWidth
      }
    }
    Array(lines, lineWidth)
  }
}