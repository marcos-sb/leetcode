object Solution {
  def hasAlternatingBits(n: Int): Boolean = {
    var _set = n & 1
    var _n = n >> 1
    while (_n > 0) {
      _set = (_set+1)%2
      if (_set == (_n & 1)) {
        _n >>= 1
      } else return false
    }
    return true
  }
}