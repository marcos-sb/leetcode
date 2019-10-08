object Solution {
  def sumEvenAfterQueries(A: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val res = new Array[Int](queries.length)
    var sumEven = A.filter(_ % 2 == 0).sum
    var i = 0
    for (q <- queries) {
      val oldVal = A(q(1))
      A(q(1)) += q(0)
      val newVal = A(q(1))
      if (newVal % 2 == 0) {
        sumEven += newVal
      }
      if (oldVal % 2 == 0) {
        sumEven -= oldVal
      }
      res(i) = sumEven
      i += 1
    }
    res
  }
}