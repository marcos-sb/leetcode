class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var n : nums) sum += n;
        if (sum % 2 == 1) return false;

        final var N = nums.length;
        final var dp = new boolean[N+1][sum/2 + 1];
        for (var r = 0; r <= N; r++) dp[r][0] = true;
        for (var r = 1; r <= N; r++) {
            for (var c = 1; c <= sum/2; c++) {
                dp[r][c] = dp[r-1][c];
                if (0 <= c - nums[r-1])
                    dp[r][c] |= dp[r-1][c-nums[r-1]];
            }
        }

        return dp[N][sum/2];
    }
}
