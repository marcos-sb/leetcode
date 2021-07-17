class Solution2 {
  public int longestUniqueCharacterSubstring(String s) {
    final Map<Character, Integer> char2idx = new HashMap<>();
    int l = 0;
    int maxLen = 0;
    for (int r = 0; r < s.length(); r++) {
      final char c = s.charAt(r);
      if (char2idx.containsKey(c)) l = Math.max(l, char2idx.get(c)+1);
      char2idx.put(c, r);
      maxLen = Math.max(maxLen, r-l+1);
    }
    return maxLen;
  }
}
