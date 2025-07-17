class Solution {
    public int coinChange(int[] coins, int amount) {
        final var n = coins.length;
        final var dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (var c : coins) {
            for (var j = c; j <= amount; ++j) {
                dp[j] = Math.min(1 + dp[j-c], dp[j]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
