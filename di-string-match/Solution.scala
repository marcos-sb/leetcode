object Solution {
  def diStringMatch(S: String): Array[Int] = {
    if (S.isEmpty) return Array.empty
    val arr = Array.fill(S.length+1)(0)
    var hi = S.length
    var lo = 0
    var k = 0
    for (c <- S) {
      c match {
        case 'I' =>
          arr(k) = lo
          lo += 1
        case 'D' =>
          arr(k) = hi
          hi -= 1
      }
      k += 1
    }
    S.last match {
      case 'I' => arr(S.length) = lo
      case 'D' => arr(S.length) = hi
    }
    arr
  }
}