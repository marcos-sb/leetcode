object Solution {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    if (left > right) List[Int]()
    else {
      def digits(n: Int): List[Int] = {
        import scala.collection.mutable.ListBuffer
        val _ret = ListBuffer[Int]()
        var _n = n
        var _div = 10
        while (_n > 0) {
          _ret += (_n % _div)
          _n /= 10
        }
        _ret.toList
      }

      (left to right).filter(n => {
        val ds = digits(n)
        ds.forall(divisor => divisor != 0 && n % divisor == 0)
      }).toList
    }
  }
}