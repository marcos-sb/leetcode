object Solution {
  def binaryGap(N: Int): Int = {
    var _max = 0
    var cur = 0
    var n = N
    while ((n & 1) != 1) {
      cur += 1
      n >>= 1
    }
    var prev = cur
    while (n > 0) {
      if ((n & 1) == 1) {
        _max = math.max(_max, cur-prev)
        prev = cur
      }
      cur += 1
      n >>= 1
    }
    _max
  }
}