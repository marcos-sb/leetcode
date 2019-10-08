object Solution {
  def minCostToMoveChips(chips: Array[Int]): Int = {
    var odds = 0
    var evens = 0
    for (c <- chips) {
      if (c % 2 == 0) evens += 1
      else odds += 1
    }
    math.min(odds,evens)
  }
}