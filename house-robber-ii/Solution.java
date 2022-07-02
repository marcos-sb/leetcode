class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 3) {
            var max = 0;
            for (var i = 0; i < nums.length; i++)
                max = Math.max(max, nums[i]);
            return max;
        }
        
        final var dp = new int[nums.length+2];
        for (var i = 2; i < dp.length-1; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-2], dp[i-1]);
        }
        final var first = dp[dp.length-2];
        
        dp[2] = 0;
        dp[3] = 0;
        for (var i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-2], dp[i-1]);
        }
        final var last = dp[dp.length-1];
        
        return Math.max(first, last);
    }
}
