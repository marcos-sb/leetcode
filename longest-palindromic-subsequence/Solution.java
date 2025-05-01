class Solution {
    public int longestPalindromeSubseq(String s) {
        final var n = s.length();
        final var dp = new int[n][n];
        for (var i = n-1; 0 <= i; --i) {
            dp[i][i] = 1;
            for (var j = i+1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
