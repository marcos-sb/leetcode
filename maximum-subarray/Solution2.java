class Solution {
    public int maxSubArray(int[] nums) {
        var runningSum = nums[0];
        var maxSum = nums[0];
        for (var i = 1; i < nums.length; i++) {
            runningSum = Math.max(nums[i], runningSum + nums[i]);
            maxSum = Math.max(maxSum, runningSum);
        }
        return maxSum;
    }
}
