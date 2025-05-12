class Solution {
    public int[] productExceptSelf(int[] nums) {
        final var n = nums.length;

        final var res = new int[n];
        res[0] = 1;
        for (var i = 1; i < n; ++i) {
            res[i] = res[i-1] * nums[i-1];
        }

        var rightProduct = 1;
        for (var i = n-1; 0 <= i; --i) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return res;
    }
}
