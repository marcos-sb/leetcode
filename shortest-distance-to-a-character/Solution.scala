object Solution {
  import collection.mutable
  def shortestToChar(S: String, C: Char): Array[Int] = {
    val cPos = mutable.BitSet()
    for (i <- S.indices; if C == S(i)) {
      cPos += i
    }
    val res = new Array[Int](S.length)
    for (i <- S.indices) {
      var minDist = Int.MaxValue
      for (j <- cPos) {
        minDist = math.min(math.abs(i-j),minDist)
      }
      res(i) = minDist
    }
    res
  }
}