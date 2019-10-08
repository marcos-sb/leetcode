object Solution {
  import scala.collection.mutable.ArrayBuffer
  def commonChars(A: Array[String]): List[String] = {
    val maps = A.map(_.groupBy(a => a).mapValues(_.length))
    var chars = maps(0).keySet
    for (map <- maps.drop(1)) {
      chars = chars.intersect(map.keySet)
    }
    var minChars = Map[String,Int]()
    for (c <- chars) {
      var minByChar = Int.MaxValue
      for (map <- maps) {
        if (map.contains(c)) {
          minByChar = math.min(minByChar, map(c))
        }
      }
      minChars += c.toString -> minByChar
    }
    val res = ArrayBuffer[String]()
    for (p <- minChars) {
      for (_ <- 0 until p._2) res += p._1
    }
    res.toList
  }
}