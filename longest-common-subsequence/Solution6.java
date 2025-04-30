class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        final var m = text1.length();
        final var n = text2.length();
        if (m < n) return longestCommonSubsequence(text2, text1);
        final var dp = new int[n+1];
        for (var i = 1; i <= m; ++i) {
            var prevDiagonal = 0;
            for (var j = 1; j <= n; ++j) {
                final var temp = dp[j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = 1 + prevDiagonal;
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                prevDiagonal = temp;
            }
        }

        return dp[n];
    }
}
