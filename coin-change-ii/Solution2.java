class Solution {
    public int change(int amount, int[] coins) {
        final var n = coins.length;
        final var dp = new int[amount+1];

        dp[0] = 1;
        for (var c : coins) {
            for (var j = c; j <= amount; ++j) {
                dp[j] += dp[j - c];
            }
        }

        return dp[amount];
    }
}
