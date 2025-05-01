class Solution {
    public int numDecodings(String s) {
        final var n = s.length();
        final var cs = s.toCharArray();

        if (cs[0] == '0') return 0;

        var dp_1 = 1;
        var dp_2 = 1;
        var dp = 0;
        for (var i = 2; i <= n; ++i) {
            final var ones = cs[i-1] - '0';
            if (valid(ones)) {
                dp = dp_1;
            }
            final var tens = cs[i-2]-'0';
            if (valid(tens) && valid(tens*10 + ones)) {
                dp += dp_2;
            }
            dp_2 = dp_1;
            dp_1 = dp;
            dp = 0;
        }

        return dp_1;
    }

    private static boolean valid(int num) {
        return 1 <= num && num <= 26;
    }
}
