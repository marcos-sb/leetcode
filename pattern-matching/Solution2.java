
class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    if (words == null || words.length == 0 || pattern.isEmpty())
      return List.of();

    final var res = new ArrayList<String>();
    for (var w : words)
      if (aligned(w, pattern)) res.add(w);

    return res;
  }

  private static boolean aligned(String word, String pat) {
    if (word.length() != pat.length()) return false;

    final var w2p = new int[256];
    final var p2w = new int[256];
    for (int i = 0; i < word.length(); i++) {
      final var cw = Character.getNumericValue(word.charAt(i));
      final var cp = Character.getNumericValue(pat.charAt(i));
      if (w2p[cw] == 0) w2p[cw] = cp;
      else if (w2p[cw] != cp) return false;
      if (p2w[cp] == 0) p2w[cp] = cw;
      else if (p2w[cp] != cw) return false;
    }

    return true;
  }
}
