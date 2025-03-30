class Solution {
    public int change(int amount, int[] coins) {
        final var n = coins.length;
        final var dp = new int[n+1][amount+1];

        for (var i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (var i = 1; i <= n; ++i) {
            for (var j = 1; j <= amount; ++j) {
                if (j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
