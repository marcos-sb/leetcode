class Solution {
    public int jump(int[] nums) {
        final var N = nums.length;
        final var dp = new int[N];
        Arrays.fill(dp, 1, N, Integer.MAX_VALUE);
        
        for (var i = 0; i < N-1; i++) {
            final var maxJump = Math.min(nums[i], N-1-i);
            for (var j = 1; j <= maxJump; j++)
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
        }
        
        return dp[N-1];
    }
}
