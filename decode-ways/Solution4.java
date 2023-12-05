class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;

        final var S = s.length();
        final var dp = new int[3];
        dp[0] = 1; dp[1] = 1;
        
        for (var i = 2; i <= S; i++) {
            dp[2] = 0;
            if (s.charAt(i-1) != '0') dp[2] = dp[1];
            final var twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (10 <= twoDigit && twoDigit <= 26) dp[2] += dp[0];
            dp[0] = dp[1]; dp[1] = dp[2];
        }

        return dp[1];
    }
}
