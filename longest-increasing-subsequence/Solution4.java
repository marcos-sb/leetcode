class Solution {
    public int lengthOfLIS(int[] nums) {
        final var n = nums.length;
        final var dp = new int[n];

        Arrays.fill(dp, 1);

        var longest = 1;
        for (var i = 1; i < n; ++i) {
            for (var j = i-1; 0 <= j; --j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }
}
