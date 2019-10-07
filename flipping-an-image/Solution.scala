object Solution {
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {

    //(in-place)
    def invert(_a: Array[Array[Int]]): Array[Array[Int]] = {
      for (i <- _a.indices; j <- _a(i).indices) {
        _a(i)(j) = if (_a(i)(j) == 1) 0 else 1
      }
      _a
    }

    //(in-place)
    def flipHorz(_a: Array[Array[Int]]): Array[Array[Int]] = {
      for (i <- _a.indices) {
        var k = _a(i).length - 1
        for (j <- 0 until _a(i).length / 2) {
          val tmp = _a(i)(j)
          _a(i)(j) = _a(i)(k)
          _a(i)(k) = tmp;
          k -= 1
        }
      }
      _a
    }

    invert(flipHorz(A))
  }
}