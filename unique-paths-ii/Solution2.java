class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        final var m = grid.length;
        final var n = grid[0].length;

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        final var dp = new int[m][n];
        dp[0][0] = 1;

        for (var i = 0; i < m; ++i) {
            for (var j = 0; j < n; ++j) {
                if (i == 0 && j == 0 || grid[i][j] == 1) continue;
                if (0 < i && 0 < j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else if (0 < i) {
                    dp[i][j] = dp[i-1][j];
                } else if (0 < j) {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
