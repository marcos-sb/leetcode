object Solution {
  def fib(N: Int): Int = {
    if (N < 2) return N
    var a = 0
    var b = 1
    var tmp = 0
    for (_ <- 0 until N-1) {
      tmp = b
      b += a
      a = tmp
    }
    return b
  }
}