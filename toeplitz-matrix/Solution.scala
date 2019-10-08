object Solution {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    for (coln <- matrix(0).indices)
      if (!checkDiagonal(matrix, 0, coln))
        return false
    for (rown <- 0 until matrix.length)
      if (!checkDiagonal(matrix, rown, 0))
        return false
    return true
  }
  private [this] def checkDiagonal(matrix: Array[Array[Int]], r: Int, c: Int): Boolean = {
    var i = 1
    var (_r, _c) = (0,0)
    while ({
      _r = r+i
      _c = c+i
      valid(matrix, _r, _c)}) {
      if (matrix(r)(c) != matrix(_r)(_c))
        return false
      i += 1
    }
    return true
  }
  private [this] def valid(matrix: Array[Array[Int]], r: Int, c: Int): Boolean = {
    0 <= r && 0 <= c && r < matrix.length && c < matrix(r).length
  }
}