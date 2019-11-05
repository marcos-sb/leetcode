object Solution {
  val vowels = Set('a','e','i','o','u')
  def toGoatLatin(S: String): String = {
    if (S.isEmpty) return ""
    var suffix = ""
    S.split(" ").map(w => {
      suffix += "a"
      (if (vowels.contains(w.head.toLower)) {
        w + "ma"
      } else {
        w.tail + w(0) + "ma"
      }) + suffix
    }).mkString(" ")
  }
}