object Solution {
  def numJewelsInStones(J: String, S: String): Int = {
    if (J != null && S != null) {
      val jewels = J.toSet
      return S.count(jewels.contains)
    }
    0
  }
}