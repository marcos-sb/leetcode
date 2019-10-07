object Solution {
  def countCharacters(words: Array[String], chars: String): Int = {
    val charsMap = chars.groupBy(c => c).mapValues(_.length)
    words.map(_.groupBy(c => c).mapValues(_.length))
      .filter(
        _.forall {
          case (c,l) => charsMap.contains(c) && l <= charsMap(c) })
      .flatten.map { case (_,l) => l }.sum
  }
}