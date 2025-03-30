class Solution {
    public int lengthOfLIS(int[] nums) {
        final var n = nums.length;
        final var dp = new int[n];

        Arrays.fill(dp, 1);
        var max = 1;
        for (var i = 1; i < n; ++i) {
            final var num = nums[i];
            var currMax = 0;
            for (var j = i-1; 0 <= j; --j) {
                if (nums[j] < num) {
                    currMax = Math.max(currMax, dp[j]);
                }
            }
            dp[i] = 1 + currMax;
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
