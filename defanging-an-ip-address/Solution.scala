object Solution {
  def defangIPaddr(address: String): String = {
    val sb = new StringBuilder()
    for (c <- address) {
      if (c == '.') sb append "[.]"
      else sb append c
    }
    sb.toString
  }
}