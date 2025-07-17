class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        var count = 0;
        var windowProduct = 1;
        var left = 0;
        final var n = nums.length;

        for (var right = 0; right < n; ++right) {
            windowProduct *= nums[right];

            while (k <= windowProduct) {
                windowProduct /= nums[left];
                ++left;
            }

            count += right - left + 1;
        }

        return count;
    }
}
