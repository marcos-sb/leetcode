class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        final var n = tasks.length;
        final var dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (var mask = 0; mask < 1 << n; ++mask) {
            if (dp[mask] == Integer.MAX_VALUE / 2) continue;
            final var remaining = (~mask) & ((1 << n) - 1);
            for (var subsets = remaining; 0 < subsets; subsets = (subsets-1) & remaining) {
                var sum = 0;
                for (var i = 0; i < n; ++i) {
                    if ((subsets & (1 << i)) != 0) {
                        sum += tasks[i];
                    }
                }
                if (sum <= sessionTime) {
                    final var newMask = mask | subsets;
                    if (dp[mask]+1 < dp[newMask]) {
                        dp[newMask] = dp[mask] + 1;
                    }
                }
            }
        }

        return dp[(1 << n) - 1];
    }
}
