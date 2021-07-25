class Solution {
  public int longestCommonSubsequenceLength(String s1, String s2) {
    final int[][] dp = new int[s1.length()+1][s2.length()+1];
    for (int r = 0; r < dp.length; r++)
      dp[r][0] = 0;
    for (int c = 0; c < dp[0].length; c++)
      dp[0][c] = 0;
    
    for (int r = 1; r < dp.length; r++) {
      for (int c = 1; c < dp[0].length; c++) {
        if (s1.charAt(r-1) == s2.charAt(c-1))
          dp[r][c] = 1 + dp[r-1][c-1];
        else
          dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
      }
    }

    return dp[dp.length-1][dp[0].length-1];
  }
}
