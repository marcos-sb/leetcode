class Solution {
  public int decodeWays(String s) {
    if (s.length() < 2) return s.length();
    final int[] cache = new int[s.length()];
    Arrays.fill(cache, -1);
    return dp(s, 0, cache);
  }
  private static int dp(String s, int i, int[] cache) {
    if (i == s.length()) return 1;

    if (cache[i] != -1) return cache[i];

    int ways = 0;
    for (int l = 1; l <= 2 && i+l <= s.length(); l++) {
      final int idx = Integer.parseInt(s.substring(i, i+l));
      if (idx == 0) return 0;
      if (idx > 26) continue;
      ways += dp(s, i+l, cache);
    }

    return cache[i] = ways;
  }
}
