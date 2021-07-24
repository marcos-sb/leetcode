public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        final int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = i;
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = i;
        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[0].length; c++) {
                if (s.charAt(r-1) == t.charAt(c-1))
                    dp[r][c] = dp[r-1][c-1];
                else
                    dp[r][c] = 1 + Math.min(dp[r-1][c-1], Math.min(dp[r][c-1], dp[r-1][c]));
            }
        }
        return dp[s.length()][t.length()] == 1;
    }
}
