class Solution {
    public int maxProduct(int[] nums) {
        final var n = nums.length;
        var max = nums[0];
        var min = nums[0];
        var globalMax = nums[0];
        for (var i = 1; i < n; ++i) {
            final var num = nums[i];
            if (0 < num) {
                max = Math.max(num, num*max);
                min = Math.min(num, num*min);
            } else {
                final var tmp = min;
                min = Math.min(num, num*max);
                max = Math.max(num, num*tmp);
            }
            globalMax = Math.max(globalMax, max);
        }

        return globalMax;
    }
}
