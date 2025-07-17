class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var num : nums) sum += num;

        if (sum % 2 != 0) return false;

        final var target = sum/2;
        final var n = nums.length;
        final var dp = new boolean[n+1][target+1];

        for (var i = 0; i <= n; ++i) {
            dp[i][0] = true;
        }

        for (var i = 1; i <= n; ++i) {
            final var num = nums[i-1];
            for (var j = 1; j <= target; ++j) {
                if (j < num) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
            }
        }

        return dp[n][target];
    }
}
