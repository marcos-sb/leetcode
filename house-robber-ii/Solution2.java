class Solution {
    public int rob(int[] nums) {
        final var N = nums.length;
        if (N == 1) return nums[0];

        // dp: {old_max_rob_i, old_max_not_rob_i, new_max_rob_i, new_max_not_rob_i}
        var dp = new int[4];
        for (var i = 0; i < N-1; i++) {
            dp[2] = dp[1] + nums[i];
            dp[3] = Math.max(dp[0], dp[1]);
            dp[0] = dp[2]; dp[1] = dp[3];
        }
        var max = Math.max(dp[0], dp[1]);

        dp = new int[4];
        for (var i = 1; i < N; i++) {
            dp[2] = dp[1] + nums[i];
            dp[3] = Math.max(dp[0], dp[1]);
            dp[0] = dp[2]; dp[1] = dp[3];
        }

        return Math.max(max, Math.max(dp[0], dp[1]));
    }
}

