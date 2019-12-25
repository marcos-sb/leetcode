object Solution {
  def findSpecialInteger(arr: Array[Int]): Int = {
    var elCount = 1
    var currEl = arr(0)
    for (el <- arr.drop(1)) {
      if (el == currEl) {
        elCount += 1
      } else {
        if (elCount > arr.length/4.0) return currEl
        elCount = 1
        currEl = el
      }
    }
    currEl
  }
}