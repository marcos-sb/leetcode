class Solution {
    public List<List<String>> partition(String s) {
        final var n = s.length();
        final var chars = s.toCharArray();

        final var dp = new boolean[n][n];

        for (var i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (var i = 0; i < n-1; ++i) {
            if (chars[i] == chars[i+1])
                dp[i][i+1] = true;
        }

        for (var len = 3; len <= n; ++len) {
            for (var i = 0; i < n - len + 1; ++i) {
                final var j = i + len - 1;
                // dp[i+1][j-1] is one char less on both ends than chars[i], chars[j]
                if (dp[i+1][j-1] && chars[i] == chars[j])
                    dp[i][j] = true;
            }
        }

        final List<List<String>> res = new ArrayList<>();
        bt(s, 0, dp, new ArrayList<>(), res);
        return res;
    }

    private static void bt(String str, int start, boolean[][] dp, List<String> partial, List<List<String>> res) {
        if (start == str.length()) {
            res.add(new ArrayList<>(partial));
            return;
        }

        for (var end = start; end < str.length(); ++end) {
            if (dp[start][end]) {
                final var substr = str.substring(start, end+1);
                partial.add(substr);
                bt(str, end+1, dp, partial, res);
                partial.remove(partial.size()-1);
            }
        }
    }
}
