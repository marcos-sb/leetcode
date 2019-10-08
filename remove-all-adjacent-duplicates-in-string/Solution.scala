object Solution {
  import collection.mutable
  def removeDuplicates(S: String): String = {
    if (S == null || S.isEmpty) return ""
    val sb = mutable.Stack[Char]()
    sb push S(0)
    for (i <- S.indices.drop(1)) {
      if (sb.nonEmpty && sb.head == S(i)) sb pop
      else sb push S(i)
    }
    sb.mkString.reverse
  }
}