class Solution {
    public int maxProduct(int[] nums) {
        final var N = nums.length;

        var max = nums[0];
        var min = nums[0];
        var globalMax = max;
        for (var i = 1; i < N; i++) {
            final var n = nums[i];
            final var tmpMax = Math.max(n, Math.max(n*max, n*min));
            min = Math.min(n, Math.min(n*max, n*min));
            max = tmpMax;
            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}
