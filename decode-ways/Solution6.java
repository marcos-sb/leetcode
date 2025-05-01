class Solution {
    public int numDecodings(String s) {
        final var n = s.length();
        final var dp = new int[n+1];
        final var cs = s.toCharArray();

        if (cs[0] == '0') return 0;

        dp[0] = 1;
        dp[1] = 1;
        for (var i = 2; i <= n; ++i) {
            final var ones = cs[i-1] - '0';
            if (valid(ones)) {
                dp[i] = dp[i-1];
            }
            final var tens = cs[i-2]-'0';
            if (valid(tens) && valid(tens*10 + ones)) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }

    private static boolean valid(int num) {
        return 1 <= num && num <= 26;
    }
}
