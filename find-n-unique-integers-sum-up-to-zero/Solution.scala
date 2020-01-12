object Solution {
  def sumZero(n: Int): Array[Int] = {
    val res = Array.fill(n)(0)
    if (n < 2) return res

    var i = 0
    for (a <- -n/2 until 0) {
      res(i) = a
      i += 1
    }
    if (n % 2 == 1) {
      res(i) = 0
      i += 1
    }
    for (a <- 1 to n/2) {
      res(i) = a
      i += 1
    }
    res
  }
}