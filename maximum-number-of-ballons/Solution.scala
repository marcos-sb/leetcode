object Solution {
  import collection.mutable
  def maxNumberOfBalloons(text: String): Int = {
    val ballonSet = mutable.Set[Char]()
    "balon".foreach(ballonSet += (_))
    val ballonMap = text.groupBy(c => c).mapValues(_.length)
      .filter(p => ballonSet.contains(p._1))
    if (ballonMap.size < ballonSet.size) 0
    else
      ballonMap
        .map(p =>
          if (p._1 == 'l' || p._1 == 'o') p._2 / 2
          else p._2)
        .min
  }
}