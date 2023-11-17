class Solution {
    public int coinChange(int[] coins, int amount) {
        final var N = amount;
        final var C = coins.length;
        final var dp = new int[N+1];
        Arrays.fill(dp, -1); // dp[a] == -1 <=> can't sum up to that amount using coins[]

        dp[0] = 0;
        for (var a = 1; a <= N; a++) {
            var min = Integer.MAX_VALUE;
            for (var c = 0; c < C; c++) {
                if (a < coins[c]) continue;
                if (dp[a-coins[c]] == -1) continue;
                min = Math.min(min, dp[a-coins[c]] + 1);
            }
            dp[a] = min == Integer.MAX_VALUE ? dp[a] : min;
        }

        return dp[N];
    }
}
