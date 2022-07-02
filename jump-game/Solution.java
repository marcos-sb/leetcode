class Solution {
    public boolean canJump(int[] nums) {
        final var N = nums.length;
        final var dp = new boolean[N];
        
        dp[N-1] = true;
        for (var i = N-2; 0 <= i; i--) {
            for (var j = Math.min(N-1-i, nums[i]); 0 < j; j--) {
                dp[i] = dp[i+j];
                if (dp[i]) break;
            }
        }
        
        return dp[0];
    }
}
