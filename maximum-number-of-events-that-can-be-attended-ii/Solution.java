class Solution {
    public int maxValue(int[][] events, int k) {
        final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[1], b[1]);
        Arrays.sort(events, cmp);
        
        final var n = events.length;
        final var dp = new int[n+1][k+1];
        for (int r = 0; r <= n; r++) Arrays.fill(dp[r], -1);
        
        return aux(events, n, k, Integer.MAX_VALUE, dp);
    }
    
    private static int aux(int[][] events, int i, int k, int start, int[][] dp) {
        if (i == 0 || k == 0) return 0;
        if (events[i-1][1] >= start) return aux(events, i-1, k, start, dp);
        if (dp[i][k] > -1) return dp[i][k];
        
        final var usingI = events[i-1][2] + aux(events, i-1, k-1, events[i-1][0], dp);
        final var notUsingI = aux(events, i-1, k, start, dp);

        return dp[i][k] = Math.max(usingI, notUsingI);
    }
    
}
