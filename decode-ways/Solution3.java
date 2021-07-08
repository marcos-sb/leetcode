class Solution3 {
  public int decodeWays(String s) {
    return dp(s);
  }

  private static int dp(String s) {
    final int[] dp = new int[s.length()+1];
    dp[0] = 1;
    for (int i = 1; i <= s.length(); i++) {
      for (int l = 1; l <= 2 && i-l >= 0; l++) {
        final int idx = Integer.parseInt(s.substring(i-l, i));
        if (idx == 0) return 0;
        if (idx > 26) continue;
        dp[i] += dp[i-l];
      }
    }

    return dp[s.length()];
  }
}
