class Solution {
    public boolean canPartition(int[] nums) {
        var sum = 0;
        for (var n : nums) sum += n;
        if (sum % 2 == 1) return false;

        final var N = nums.length;
        final var dp = new boolean[sum/2 + 1];
        for (var r = 0; r <= N; r++) dp[0] = true;
        for (var r = 1; r <= N; r++) {
            for (var c = sum/2; 0 <= c; c--) {
                if (0 <= c - nums[r-1])
                    dp[c] |= dp[c-nums[r-1]];
            }
        }

        return dp[sum/2];
    }
}
