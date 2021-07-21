class Solution {
  private int maxLen = 0;

  public int lengthOfLNDS(int[] nums) {
    if (nums == null) return -1;
    bt(nums, -1, 0, 0);
    return maxLen;
  }

  private void bt(int[] nums, int i, int j, int len) {
    if (j == nums.length) {
      maxLen = Math.max(maxLen, len);
      return;
    }

    if (i == -1 || nums[i] <= nums[j])
      bt(nums, j, j+1, len+1);

    bt(nums, i, j+1, len);
  }
}
