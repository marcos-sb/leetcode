class Solution {
    public int maxSubArray(int[] nums) {
        var runningSum = nums[0];
        var max = runningSum;
        
        for (var i = 1; i < nums.length; i++) {
            if (runningSum <= 0) runningSum = nums[i];
            else runningSum += nums[i];
            max = Math.max(max, runningSum);
        }
        
        return max;
    }
}
