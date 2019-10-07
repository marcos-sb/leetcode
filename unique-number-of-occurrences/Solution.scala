object Solution {
  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    arr
      .groupBy(c => c)
      .map(p => p._2.length)
      .toArray
      .groupBy(c => c)
      .map(p => p._2.length)
      .count(_ > 1) == 0
  }
}