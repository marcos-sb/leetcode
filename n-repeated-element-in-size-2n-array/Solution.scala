object Solution {
  def repeatedNTimes(A: Array[Int]): Int = {
    var s = Set[Int]()
    for (n <- A) {
      if (!s(n)) s += n
      else return n
    }
    A(0)
  }
}