class Solution {
    public int pivotIndex(int[] nums) {
        var rightSum = 0;
        for (var j = nums.length-1; 0 < j; j--)
            rightSum += nums[j];
        
        var leftSum = 0;
        var i = 0;
        while (true) {
            if (leftSum == rightSum) return i;
            leftSum += nums[i++];
            if (i == nums.length) return -1;
            rightSum -= nums[i];
        }
    }
}
