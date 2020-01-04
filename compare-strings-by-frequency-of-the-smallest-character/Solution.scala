object Solution {
  import util.control.Breaks.{break, breakable}
  def numSmallerByFrequency(queries: Array[String], words: Array[String]): Array[Int] = {
    val fq = queries.map(freqSmallerChar)
    val fw = words.map(freqSmallerChar).sorted
    fq.map(smallerThan(fw,_))
  }
  def freqSmallerChar(s: String): Int = {
    if (s == null || s.isEmpty) return 0
    var smaller = s.min
    var freq = 0
    for (c <- s) {
      if (c == smaller) {
        freq += 1
      }
    }
    return freq
  }
  def smallerThan(arr: Array[Int], n: Int): Int = {
    var lo = 0
    var hi = arr.length-1
    var mid = 0
    breakable {
      while (lo < hi) {
        mid = lo + (hi-lo)/2
        if (n < arr(mid)) {
          hi = mid - 1
        } else if (arr(mid) < n) {
          lo = mid + 1
        } else break
      }
    }
    if (lo == hi) mid = lo
    while (mid < arr.length && arr(mid) <= n) {
      mid += 1
    }
    return arr.length - mid
  }
}