object Solution {
  def findNumbers(nums: Array[Int]): Int = {
    nums.map(digits).count(_ % 2 == 0)
  }
  def digits(n: Int): Int = {
    if (n == 0) return 1
    var _n = n
    var count = 0
    while (_n > 0) {
      _n /= 10
      count += 1
    }
    count
  }
}