class Solution {
    public int missingNumber(int[] nums) {
        final var N = nums.length;
        // Use Cyclic Sort to place each integer in its corresponding index...
        for (var i = 0; i < N; i++) {
            while (nums[i] != i && nums[i] != N) {
                final var tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }

        // Then, find the first index that is missing its corresponding element.
        var cmp = 0;
        for (var n : nums) {
            if (cmp != n) return cmp;
            cmp++;
        }

        // If you can't find, it's because the missing integer is
        // the one with no index in the array
        return N;
    }
}
