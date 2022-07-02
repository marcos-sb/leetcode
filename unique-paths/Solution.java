class Solution {
    public int uniquePaths(int m, int n) {
        final var dp = new int[m][n];
        for (var r = 0; r < m; r++) dp[r][0] = 1;
        for (var c = 1; c < n; c++) dp[0][c] = 1;
        for (var r = 1; r < m; r++)
            for (var c = 1; c < n; c++)
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
        
        return dp[m-1][n-1];
    }
}
