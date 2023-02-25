class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        final var dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (var i = 1; i <= amount; i++) {
            for (var c : coins) {
                if (0 <= i-c) dp[i] = Math.min(dp[i-c] + 1, dp[i]);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
