public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        final Comparator<int[]> cmp = (a,b) -> {
            final int wCmp = Integer.compare(a[0], b[0]);
            if (wCmp != 0) return wCmp;
            return Integer.compare(a[1], b[1]);
        };
        
        Arrays.sort(envelopes, cmp);

        final int N = envelopes.length;
        final int[] dp = new int[N];
        int maxLen = 0;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]++;
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }
}
