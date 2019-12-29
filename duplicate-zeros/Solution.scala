object Solution {
  import util.control.Breaks.{breakable, break}
  def duplicateZeros(arr: Array[Int]): Unit = {
    val resHelper = new Array[Int](arr.length)
    var k = 0
    breakable {
      for (el <- arr) {
        if (k >= arr.length) break
        resHelper(k) = el
        k += 1
        if (k >= arr.length) break
        if (el == 0) {
          resHelper(k) = 0
          k += 1
        }
      }
    }
    k = 0
    for (el <- resHelper) {
      arr(k) = el
      k += 1
    }
  }
}