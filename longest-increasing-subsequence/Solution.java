class Solution {
    public int lengthOfLIS(int[] nums) {
        final var N = nums.length;
        final var dp = new int[N];
        var max = 1;
        dp[0] = 1;
        for (var i = 1; i < N; i++) {
            dp[i] = 1;
            for (var j = i-1; 0 <= j; j--) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
