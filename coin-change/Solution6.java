class Solution {
    public int coinChange(int[] coins, int amount) {
        final var n = coins.length;
        final var dp = new int[amount+1];

        for (var j = 1; j <= amount; ++j) {
            dp[j] = Integer.MAX_VALUE - 1; // to avoid ovf
        }

        for (var coin : coins) {
            for (var j = coin; j <= amount; ++j) {
                dp[j] = Math.min(1 + dp[j-coin], dp[j]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
