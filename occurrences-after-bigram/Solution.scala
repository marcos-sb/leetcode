object Solution {
  import collection.mutable
  def findOcurrences(text: String, first: String, second: String): Array[String] = {
    val res = mutable.ArrayBuffer[String]()
    if (res == null) return res.toArray
    val words = text.split(" ")
    for (i <- words.indices.drop(2);
         if words(i-2) == first && words(i-1) == second) {
      res += words(i)
    }
    res.toArray
  }
}