class Solution {
    public void moveZeroes(int[] nums) {
        var N = nums.length;
        var nonZeroIndx = 0;
        for (var i = 0; i < N; i++) {
            if (nums[i] != 0) swap(nums, i, nonZeroIndx++);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
