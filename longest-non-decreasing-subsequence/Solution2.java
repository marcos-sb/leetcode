class Solution2 {
  public int lengthOfLNDS(int[] nums) {
    final int[] dp = new int[nums.length];
    int maxLen = 1;
    dp[0] = 1;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[j] <= nums[i]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
      maxLen = Math.max(maxLen, dp[i]);
    }
    
    return maxLen;
  }
}
