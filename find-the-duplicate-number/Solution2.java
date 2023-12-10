class Solution {
    public static int findDuplicate(int[] nums) {
        final var N = nums.length;
        for (var i = 0; i < N; i++) {
            while (nums[i]-1 != i) {
                // Detect dup
                if (nums[nums[i]-1] == nums[i]) return nums[i];

                // Put in the right index
                final var tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        // Assuming there's a duplicate in `nums`, this statement is unreachable
        return -1;
   }
}
