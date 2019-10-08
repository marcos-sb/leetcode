object Solution {
  def sortArrayByParityII(A: Array[Int]): Array[Int] = {
    val res = Array.fill(A.length)(0)
    var oddi = 1
    var eveni = 0
    for (n <- A) {
      if (n % 2 == 0) {
        res(eveni) = n
        eveni += 2
      } else {
        res(oddi) = n
        oddi += 2
      }
    }
    res
  }
}