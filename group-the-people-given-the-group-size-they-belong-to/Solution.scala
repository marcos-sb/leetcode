object Solution {
  import collection.mutable
  def groupThePeople(groupSizes: Array[Int]): List[List[Int]] = {
    val sz2people = mutable.Map[Int,mutable.ArrayBuffer[Int]]()
    var res = List[List[Int]]()
    for (i <- groupSizes.indices) {
      val gsz = groupSizes(i)
      if (!sz2people.contains(gsz))
        sz2people(gsz) = mutable.ArrayBuffer[Int]()
      val l = sz2people(gsz)
      l += i
      if (l.length == gsz) {
        res = l.toList :: res
        sz2people -= groupSizes(i)
      }
    }
    res
  }
}