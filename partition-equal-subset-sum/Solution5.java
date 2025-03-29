class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        final var target = sum/2;
        final var n = nums.length;
        final var dp = new boolean[target+1];

        dp[0] = true;
        for (var num : nums) {
            for (var c = target; num <= c; --c) {
                dp[c] = dp[c] || dp[c-num];
            }
        }

        return dp[target];
    }
}
