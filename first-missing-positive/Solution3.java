class Solution {
    public int firstMissingPositive(int[] nums) {
        final var N = nums.length;

        // We only need to check what integer is missing in nums from [1, N].
        // We can ignore integers outside of that range because they are not
        // relevant for the implementation.
        for (var i = 0; i < N; i++) {

            // Using Cyclic Sort we ignore integers out of the range [1, N],
            // and integers already at the right index.
            while (!(nums[i] < 1 || N < nums[i] || nums[i]-1 == i)) {
                final var tmp = nums[nums[i]-1];
                if (tmp == nums[i]) break; // This is to handle duplicates, or we'd loop forever.
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        // Return the first integer that is not at the right index...
        var cmp = 1;
        for (var i = 0; i < N; i++) {
            if (cmp != nums[i]) return cmp;
            cmp++;
        }

        return N+1;
    }
}
