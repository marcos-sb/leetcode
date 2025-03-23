class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final var M = obstacleGrid.length;
        final var N = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[M-1][N-1] == 1) return 0;
        final var dp = new int[M][N];
        dp[0][0] = 1;
        for (var r = 0; r < M; ++r) {
            for (var c = 0; c < N; ++c) {
                if (obstacleGrid[r][c] == 1) continue;
                if (0 < r) dp[r][c] += dp[r-1][c];
                if (0 < c) dp[r][c] += dp[r][c-1];
            }
        }
        return dp[M-1][N-1];
    }
}
