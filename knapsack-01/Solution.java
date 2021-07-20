class Solution {
  public int knapsack(int[] values, int[] weights, int maxWeightConstraint) {
    final int[][] dp = new int[values.length+1][maxWeightConstraint+1];

    for (int c = 0; c < dp[0].length; c++) {
      dp[0][c] = 0;
    }
    for (int r = 1; r < dp.length; r++) {
      dp[r][0] = 0;
    }

    for (int c = 1; c < dp[0].length; c++) {
      for (int r = 1; r < dp.length; r++) {
        final int valueWithout = dp[r-1][c];

        int valueWith = 0;
        if (c - weights[r-1] >= 0) {
          valueWith = values[r-1] + dp[r-1][c-weights[r-1]];
        }

        dp[r][c] = Math.max(valueWith, valueWithout);
      }
    }

    return dp[values.length][maxWeightConstraint];
  }
}
