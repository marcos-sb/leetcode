class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        var sum = 0;
        for (var num : nums) sum += num;

        // sum_positive - sum_negative = target [1]
        // sum_positive + sum_negative = sum    [2]
        // => 2 sum_pos = target+sum
        // sum_pos = (target+sum) / 2

        if (sum < Math.abs(target) || (target+sum) % 2 != 0)
            return 0;

        final var sumPos = (target+sum) / 2;
        final var dp = new int[sumPos+1];
        dp[0] = 1;
        for (var num : nums) {
            for (var i = sumPos; num <= i; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[sumPos];
    }
}
