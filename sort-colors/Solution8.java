class Solution {
    public void sortColors(int[] nums) {
        var left = 0;
        var right = nums.length-1;
        var i = 0;
        while (i <= right) {
            if (nums[i] == 0) swap(nums, i++, left++);
            else if (nums[i] == 2) swap(nums, i, right--);
            else i++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        final var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
