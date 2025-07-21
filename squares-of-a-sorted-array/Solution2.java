class Solution {
    public int[] sortedSquares(int[] nums) {
        final var n = nums.length;
        var left = 0;
        var right = n - 1;
        final var res = new int[n];
        for (var i = n-1; 0 <= i; --i) {
            final var leftNum = nums[left] * nums[left];
            final var rightNum = nums[right] * nums[right];
            if (leftNum < rightNum) {
                res[i] = rightNum;
                --right;
            } else {
                res[i] = leftNum;
                ++left;
            }
        }
        return res;
    }
}
