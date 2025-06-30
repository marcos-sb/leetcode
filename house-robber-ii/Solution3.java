class Solution {
    public int rob(int[] nums) {
        final var n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        final var dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (var i = 2; i <= n-2; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        var tmpMax = dp[n-2];

        dp[0] = 0;
        dp[1] = nums[1];
        for (var i = 2; i <= n-1; ++i) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return Math.max(tmpMax, dp[n-1]);
    }
}
