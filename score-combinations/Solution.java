class Solution {
  public int totalWaysToReachScore(int finalScore, int[] pointEvents) {
    if (finalScore <= 0 || pointEvents == null || pointEvents.length < 1) return 0;
    return dp(finalScore, pointEvents);
  }

  private static int dp(int finalScore, int[] pointEvents) {
    final int[][] dp = new int[pointEvents.length+1][finalScore+1];
    for (int r = 0; r < dp.length; r++)
      dp[r][0] = 1;
    for (int c = 0; c < dp[0].length; c++)
      dp[0][c] = 0;
    
    for (int r = 1; r < dp.length; r++) {
      for (int score = 1; score < dp[0].length; score++) {
        final int currPoints = pointEvents[r-1];
        final int withoutCurrPoints = dp[r-1][score];
        
        int withCurrPoints = 0;
        if (currPoints <= score) {
          withCurrPoints = dp[r][score - currPoints];
        }

        dp[r][score] = withoutCurrPoints + withCurrPoints;
      }
    }

    return dp[pointEvents.length][finalScore];
  }
}
