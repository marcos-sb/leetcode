object Solution {
  import collection.mutable
  def numSpecialEquivGroups(A: Array[String]): Int = {
    A.map(getMaps(_)).groupBy(m => m).size
  }
  def getMaps(s: String): (mutable.Map[Char,Int],mutable.Map[Char,Int]) = {
    val even = mutable.Map[Char,Int]()
    val odd = mutable.Map[Char,Int]()
    for (i <- s.indices) {
      i % 2 match {
        case 0 =>
          even(s(i)) = even.getOrElse(s(i), 0) + 1
        case 1 =>
          odd(s(i)) = odd.getOrElse(s(i), 0) + 1
      }
    }
    (even,odd)
  }
}