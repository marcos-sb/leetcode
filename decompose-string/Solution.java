class Solution {
  public boolean canDecompose(List<String> dictionary, String s) {
    final Set<String> dict = new HashSet<>(dictionary);
    return bt(dict, s, 0, new boolean[s.length()]);
  }

  private static boolean bt(Set<String> dict, String s, int i, boolean[] cache) {
    if (i == s.length()) return true;
    if (cache[i]) return false;
    
    for (int j = 1; j + i <= s.length(); j++) {
      final String ss = s.substring(i, i+j);
      if (!dict.contains(ss)) continue;
      final boolean canBeDecomposed = bt(dict, s, i+j, cache);
      if (canBeDecomposed) return true;
    }

    return !(cache[i] = true);
  }
}
