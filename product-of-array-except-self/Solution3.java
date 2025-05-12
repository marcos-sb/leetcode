class Solution {
    public int[] productExceptSelf(int[] nums) {
        final var n = nums.length;

        final var leftProduct = new int[n];
        leftProduct[0] = nums[0];
        for (var i = 1; i < n; ++i) {
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        final var rightProduct = new int[n];
        rightProduct[n-1] = nums[n-1];
        for (var i = n-2; 0 <= i; --i) {
            rightProduct[i] = rightProduct[i+1] * nums[i];
        }

        final var res = new int[n];
        res[0] = rightProduct[1];
        res[n-1] = leftProduct[n-2];
        for (var i = 1; i < n-1; ++i) {
            res[i] = leftProduct[i-1] * rightProduct[i+1];
        }

        return res;
    }
}
