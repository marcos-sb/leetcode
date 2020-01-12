object Solution {
  def freqAlphabets(s: String): String = {
    val res = new StringBuilder()
    var i = s.length() - 1
    val zeroChar = 'a' - 1
    while (i >= 0) {
      if (s(i) == '#') {
        res.append((toInt(s(i-2),s(i-1)) + zeroChar).toChar)
        i -= 3
      } else {
        res.append((zeroChar + s(i) - '0').toChar)
        i -= 1
      }
    }
    res.reverse.toString
  }
  private [this] def toInt(tens: Char, ones: Char): Int =
    (tens - '0') * 10 + (ones - '0')
}