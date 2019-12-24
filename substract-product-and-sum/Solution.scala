object Solution {
  def subtractProductAndSum(n: Int): Int = {
    digitOp(n, _*_, 1) - digitOp(n, _+_, 0)
  }
  def digitOp(n: Int, op: (Int,Int) => Int, nel: Int) = {
    var res = nel
    var _n = n
    while (_n > 0) {
      res = op(_n % 10, res)
      _n /= 10
    }
    res
  }
}