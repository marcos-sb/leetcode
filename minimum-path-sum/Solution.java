class Solution {
    public int minPathSum(int[][] grid) {
        final var M = grid.length;
        final var N = grid[0].length;
        final var dp = new int[M][N];
        dp[0][0] = grid[0][0];

        for (var i = 0; i < M; ++i) {
            for (var j = 0; j < N; ++j) {
                if (0 == i && 0 == j) continue;
                var left = Integer.MAX_VALUE;
                if (0 < j) {
                    left = dp[i][j-1];
                }
                var top = Integer.MAX_VALUE;
                if (0 < i) {
                    top = dp[i-1][j];
                }
                dp[i][j] = Math.min(left, top) + grid[i][j];
            }
        }

        return dp[M-1][N-1];
    }
}
