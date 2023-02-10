class Solution {
    public int climbStairs(int n) {
        final var dp = new int[n+1];
        dp[0] = 1;
        for (var i = 1; i <= n; i++) {
            for (var j = 1; j <= 2; j++)
                if (0 <= i-j) dp[i] += dp[i-j];
        }
        return dp[n];
    }
}
