object Solution {
  def replaceElements(arr: Array[Int]): Array[Int] = {
    var _max = arr.last
    for (i <- arr.length-2 to 0 by -1) {
      val newMax = math.max(_max, arr(i))
      arr(i) = _max
      _max = newMax
    }
    arr(arr.length-1) = -1
    arr
  }
}