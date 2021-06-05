class Solution2 {
  public int longestPalindrome(String s) {
    if (s.length() <= 1) return s.length();

    final var set = new HashSet<Character>();
    var max = 0;
    for (var i = 0; i < s.length(); i++) {
      final var c = s.charAt(i);
      if (set.contains(c)) {
        max += 2;
        set.remove(c);
      } else set.add(c);
    }

    if (set.size() >= 1) return max+1;
    return max;
  }
}
