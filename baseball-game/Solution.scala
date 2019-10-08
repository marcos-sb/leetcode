object Solution {
  def calPoints(ops: Array[String]): Int = {
    var st = List[Int]()
    for (op <- ops) op match {
      case "+" =>
        if (st.length > 1) {
          val prev = st.head
          val pprev = st.tail.head
          st ::= prev + pprev
        }
      case "D" =>
        if (st.nonEmpty) {
          st ::= st.head * 2
        }
      case "C" =>
        if (st.nonEmpty) {
          st = st.tail
        }
      case s:String => st ::= s.toInt
      case _ =>
    }
    return st.sum
  }
}