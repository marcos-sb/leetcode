class Solution {
    public void moveZeroes(int[] nums) {
        var N = nums.length;
        var l = 0;
        var r = N-1;
        while (l < r) {
            if (nums[l] == 0) {
                for (var i = l; i < r; i++)
                    swap(nums, i, i+1);
                r--;
            } else l++;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

