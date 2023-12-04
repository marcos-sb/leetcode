class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final var M = text1.length();
        final var N = text2.length();
        final var dp = new int[M+1][N+1];
        for (var r = 1; r <= M; r++) {
            for (var c = 1; c <= N; c++) {
                if (text1.charAt(r-1) == text2.charAt(c-1))
                    dp[r][c] = dp[r-1][c-1] + 1;
                else
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
            }
        }
        return dp[M][N];
    }
}
