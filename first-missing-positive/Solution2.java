class Solution {
    public int firstMissingPositive(int[] nums) {
        final var N = nums.length;

        // Check if 1 is present. If it's not, return 1.
        var containsOne = contains(nums, 1);
        if (!containsOne) return 1;

        // Replace integers out of the range [1, N] with 1.
        // We could ignore them in the next step instead,
        // but this way the code is tighter.
        replace(nums, 1, N, 1);

        // Now all integers in nums are within [1, N].
        // We're going to use the indices of nums to mean 'is present' the number
        // `index + 1` is present in the array. To do that, we're going to change
        // the sign of the integers at those indices, to negative.
        for (var i = 0; i < N; i++) {
            final var idx = Math.abs(nums[i])-1;

            // Mark as negative only once
            if (nums[idx] < 0) continue;
            nums[idx] *= -1;
        }

        // Traverse nums one last time to find the first positive integer
        // and return that index + 1: this is the smallest integer that's
        // missing.
        for (var i = 1; i < N; i++)
            if (0 < nums[i]) return i+1;

        return N+1;
    }

    private static boolean contains(int[] nums, int n) {
        for (var _n : nums)
            if (n == _n) return true;
        return false;
    }

    private static void replace(int[] nums, int lo, int hi, int n) {
        final var N = nums.length;
        for (var i = 0; i < N; i++)
            if (nums[i] < lo || hi < nums[i]) nums[i] = n;
    }
}
