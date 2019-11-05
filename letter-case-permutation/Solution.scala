object Solution {
  def letterCasePermutation(S: String): List[String] = {
    var res = List(new StringBuilder)
    for (c <- S) {
      if (isLetter(c)) {
        res = appendAll(c, dupAll(res))
      } else {
        res = appendAll(c, res)
      }
    }
    res.map(_.toString)
  }
  def isLetter(c: Char): Boolean = 'A' <= c && c <= 'z'
  def dupAll(l: List[StringBuilder]): List[StringBuilder] = {
    var newList = List[StringBuilder]()
    for (sb <- l) {
      newList = (sb :: sb.clone :: newList)
    }
    newList
  }
  def appendAll(c: Char, l: List[StringBuilder]): List[StringBuilder] = {
    for (i <- l.indices) {
      if (i % 2 == 0) {
        l(i).append(c.toLower)
      } else {
        l(i).append(c.toUpper)
      }
    }
    l
  }
}