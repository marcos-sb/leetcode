class Solution {
    public int rob(int[] nums) {
        final var n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            nums[i] = Math.max(nums[i-2] + nums[i], nums[i-1]);
        }

        return nums[n-1];
    }
}
