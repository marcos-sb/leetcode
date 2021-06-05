
class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    if (words == null || words.length == 0 || pattern.isEmpty())
      return List.of();

    final var normalisedPat = normalise(pattern);
    final var res = new ArrayList<String>();
    for (var w : words) {
      if (normalise(w).equals(normalisedPat)) res.add(w);
    }
    return res;
  }

  private static String normalise(String pat) {
    final var letter2index = new HashMap<Character, Integer>();
    int idx = 0;
    final var sb = new StringBuilder();
    for (int j = 0; j < pat.length(); j++) {
      final var c = pat.charAt(j);
      letter2index.putIfAbsent(c, idx++);
      sb.append(letter2index.get(c));
    }
    return sb.toString();
  }
}
