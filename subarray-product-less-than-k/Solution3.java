class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        final var N = nums.length;
        var res = 0;
        var i = 0;
        var j = 0;
        var windowProd = 1;
        while (j < N) {
            windowProd *= nums[j++];
            while (i < j && k <= windowProd) {
                windowProd /= nums[i++];
            }
            res += j-i;
        }
        return res;
    }
}
