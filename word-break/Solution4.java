class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final var n = s.length();
        final var ws = new HashSet<String>(wordDict);
        final var dp = new boolean[n+1];

        dp[0] = true;
        for (var j = 1; j <= n; ++j) {
            for (var i = 0; i < j; ++i) {
                if (!dp[i]) continue;
                final var ss = s.substring(i, j);
                if (ws.contains(ss)) {
                    dp[j] = true;
                }
            }
        }

        return dp[n];
    }
}
