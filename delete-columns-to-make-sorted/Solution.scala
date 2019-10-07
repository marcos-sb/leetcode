object Solution {
  import scala.util.control.Breaks.{breakable, break}
  def minDeletionSize(A: Array[String]): Int = {
    var minDel = 0
    for (si <- A(0).indices) {
      breakable {
        for (ai <- A.indices.drop(1)) {
          if (A(ai-1)(si) > A(ai)(si)) {
            minDel += 1
            break
          }
        }
      }
    }
    minDel
  }
}