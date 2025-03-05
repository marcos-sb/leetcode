class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        var currentMaxSum = nums[0];
        var maxSum = nums[0];
        var currentMinSum = nums[0];
        var minSum = nums[0];
        var totalSum = nums[0];
        for (var i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(nums[i], currentMaxSum + nums[i]);
            maxSum = Math.max(maxSum, currentMaxSum);
            currentMinSum = Math.min(nums[i], currentMinSum + nums[i]);
            minSum = Math.min(minSum, currentMinSum);
            totalSum += nums[i];
        }

        if (maxSum < 0) return maxSum; // every integer < 0

        return Math.max(maxSum, totalSum - minSum);
    }
}
