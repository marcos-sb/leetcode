object Solution {
  def smallestRangeI(A: Array[Int], K: Int): Int = {
    val (minA,maxA) = (A.min,A.max)
    val diff = maxA-K - (minA+K)
    if (diff < 0) 0
    else diff
  }
}