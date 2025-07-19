class Solution {
    public String longestPalindrome(String s) {
        final var n = s.length();
        if (n < 2) return s;

        final var chars = s.toCharArray();
        final var dp = new boolean[n][n];

        var start = 0;
        var maxLen = 1;

        for (var i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (var i = 0; i < n-1; ++i) {
            if (chars[i] == chars[i+1]) {
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (var len = 3; len <= n; ++len) {
            for (var i = 0; i <= n-len; ++i) {
                final var j = i + len - 1;
                if (chars[i] == chars[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if (maxLen < len) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
