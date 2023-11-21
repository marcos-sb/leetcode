class Solution {
    public int[] countBits(int n) {
        if (n == 0) return new int[]{0};
        
        final var dp = new int[n+1];
        dp[1] = 1;
        for (var i = 2; i <= n; i++)
            dp[i] = i % 2 == 0 ? dp[i/2] : dp[i/2] + 1;

        return dp;
    }
}
