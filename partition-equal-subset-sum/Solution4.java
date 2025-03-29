class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        final var target = sum/2;
        final var n = nums.length;
        final var dp = new boolean[n+1][target+1];

        for (var r = 0; r <= n; ++r) {
            dp[r][0] = true;
        }

        for (var r = 1; r <= n; ++r) {
            for (var c = 1; c <= target; ++c) {
                if (c < nums[r-1]) dp[r][c] = dp[r-1][c];
                else dp[r][c] = dp[r-1][c] || dp[r-1][c-nums[r-1]];
            }
        }

        return dp[n][target];
    }
}
