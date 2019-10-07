object Solution {;
  def removeOuterParentheses(S: String): String = {
    var opens = 0
    val sb = new StringBuilder()
    for (c <- S) c match {
      case '(' =>
        if (0 < opens) sb append '('
        opens += 1
      case ')' =>
        if (1 < opens) sb append ')'
        opens -= 1
    }
    sb.toString
  }
}