class Solution {
    public int maxProduct(int[] nums) {
        final var N = nums.length;
        final var dpMax = new int[N];
        final var dpMin = new int[N];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        var max = nums[0];
        for (var i = 1; i < N; i++) {
            if (nums[i] > 0) {
                dpMax[i] = Math.max(nums[i], dpMax[i-1]*nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i-1]*nums[i]);
            } else {
                dpMax[i] = Math.max(nums[i], dpMin[i-1]*nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i-1]*nums[i]);
            }
            max = Math.max(max, dpMax[i]);
        }

        return max;
    }
}
