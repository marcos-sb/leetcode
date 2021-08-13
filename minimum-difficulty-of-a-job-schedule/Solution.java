class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        final var jd = jobDifficulty;
        final var N = jd.length;
        final var dp = new int[d][N];
        
        if (N < d) return -1;
        
        dp[0][0] = jd[0];
        for (int c = 1; c < N; c++)
            dp[0][c] = Math.max(dp[0][c-1], jd[c]);
        
        for (int r = 1; r < d; r++) {
            for (int c = r; c < N; c++) {
                dp[r][c] = Integer.MAX_VALUE;
                int max = 0;
                for (int i = c; i >= r; i--) {
                    max = Math.max(jd[i], max);
                    dp[r][c] = Math.min(dp[r-1][i-1] + max, dp[r][c]);
                }
            }
        }
        
        return dp[d-1][N-1];
    }
}
