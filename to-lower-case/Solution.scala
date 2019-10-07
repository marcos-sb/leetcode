object Solution {
  def toLowerCase(str: String): String = {
    str.map( c => if (c >= 65 && c <= 90) (c.toInt + 32).toChar else c )
  }
}