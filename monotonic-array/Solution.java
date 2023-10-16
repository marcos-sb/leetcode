class Solution {
    public boolean isMonotonic(int[] nums) {
        final var N = nums.length;
        if (N <= 1) return true;
        var inc = isIncreasing(nums, 1);
        for (var i = 2; i < N; i++) {
            final var newInc = isIncreasing(nums, i);
            if (inc == null) inc = newInc;
            else if (newInc != null && inc != newInc) return false;
        }

        return true;
    }

    private static Boolean isIncreasing(int[] nums, int i) {
        Boolean inc = true;
        if (nums[i-1] > nums[i]) inc = false;
        else if (nums[i-1] == nums[i]) inc = null;
        return inc;
    }
}
