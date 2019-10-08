object Solution {
  def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
    val arrSorted = arr.sorted
    var minDiff = Int.MaxValue
    for (i <- arrSorted.indices.drop(1)) {
      minDiff = math.min(math.abs(arrSorted(i) - arrSorted(i-1)), minDiff)
    }
    println(minDiff)
    var res = List[List[Int]]()
    for (i <- arrSorted.indices.reverse.drop(1)) {
      if (math.abs(arrSorted(i)-arrSorted(i+1)) == minDiff)
        res ::= List(arrSorted(i),arrSorted(i+1))
    }
    res
  }
}