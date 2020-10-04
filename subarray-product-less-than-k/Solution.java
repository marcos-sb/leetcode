class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        var total = 0;
        var prod = 1;
        var i = 0;
        for (int j = 0; j < nums.length; j++) {
            prod *= nums[j];
            while (prod >= k) prod /= nums[i++];
            total += j - i + 1;
        }
        return total;
    }
}
