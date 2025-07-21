class Solution {
    public int pivotIndex(int[] nums) {
        final var n = nums.length;

        var leftSum = 0;
        var rightSum = 0;
        for (var num : nums) {
            rightSum += num;
        }

        for (var i = 0; i < n; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
