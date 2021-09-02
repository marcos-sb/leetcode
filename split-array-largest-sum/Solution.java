class Solution {
    public int splitArray(int[] nums, int m) {
        final var dp = new int[m][nums.length];
        
        dp[0][0] = nums[0];
        for (var c = 1; c < nums.length; c++)
            dp[0][c] = dp[0][c-1] + nums[c];
        
        for (var r = 1; r < dp.length; r++) {
            for (var c = r; c < dp[0].length; c++) {
                var sum = nums[c];
                var min = Integer.MAX_VALUE;
                for (var i = c; i >= r; i--) {
                    min = Math.min(min, Math.max(sum, dp[r-1][i-1]));
                    sum += nums[i-1];
                }
                dp[r][c] = min;
            }
        }
        
        
        return dp[m-1][nums.length-1];
    }
}
