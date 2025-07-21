class Solution {
    public void moveZeroes(int[] nums) {
        final var n = nums.length;
        var zeros = 0;
        var i = 0;
        for (var num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        for (var j = i; j < n; ++j) {
            nums[j] = 0;
        }
    }
}
