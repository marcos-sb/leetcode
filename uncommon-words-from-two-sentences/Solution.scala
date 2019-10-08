object Solution {
  import collection.mutable
  def uncommonFromSentences(A: String, B: String): Array[String] = {
    val mapA = A.split(" ").groupBy(c => c).mapValues(_.length)
    val mapB = B.split(" ").groupBy(c => c).mapValues(_.length)
    val res = mutable.ArrayBuffer[String]()
    for (wordTimes <- mapA) {
      if (wordTimes._2 == 1 && !mapB.contains(wordTimes._1))
        res += wordTimes._1
    }
    for (wordTimes <- mapB) {
      if (wordTimes._2 == 1 && !mapA.contains(wordTimes._1))
        res += wordTimes._1
    }
    res.toArray
  }
}