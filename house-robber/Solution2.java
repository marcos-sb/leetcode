class Solution {
    public int rob(int[] nums) {
        final var N = nums.length;
        final var dp = new int[2][N];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (var i = 1; i < N; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = dp[0][i-1] + nums[i];
        }
        return Math.max(dp[0][N-1], dp[1][N-1]);
    }
}
