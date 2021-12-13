class Solution {
    public void moveZeroes(int[] nums) {
        var i = 0;
        for (var k = 0; k < nums.length; k++) {
            if (nums[k] == 0) continue;
            nums[i++] = nums[k];
        }
        for (var k = i; k < nums.length; k++)
            nums[k] = 0;
    }
}
