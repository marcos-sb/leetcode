class Solution {
  public int maxContiguousSubarraySum(int[] nums) {
    if (nums.length == 0) return -1;
    int sum = nums[0];
    int max = sum;
    for (int i = 1; i < nums.length; i++) {
      sum = Math.max(nums[i], sum+nums[i]);
      max = Math.max(sum, max);
    }
    return max;
  }
}
