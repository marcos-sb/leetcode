class Solution {
    public int maxProduct(int[] nums) {
        final var N = nums.length;
        var maxi = nums[0];
        var mini = nums[0];
        var max = nums[0];
        for (var i = 1; i < N; i++) {
            if (nums[i] > 0) {
                maxi = Math.max(nums[i], maxi*nums[i]);
                mini = Math.min(nums[i], mini*nums[i]);
            } else {
                final var tmp = mini;
                mini = Math.min(nums[i], maxi*nums[i]);
                maxi = Math.max(nums[i], tmp*nums[i]);
            }
            max = Math.max(max, maxi);
        }

        return max;
    }
}
