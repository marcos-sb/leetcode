class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        final var N = nums.length;
        var count = 0;
        var prod = 1;
        var l = 0;
        for (var r = 0; r < N; r++) {
            prod *= nums[r];
            while (l < r && k <= prod) prod /= nums[l++];
            if (k <= prod) continue;
            count += r-l+1;
        }
        
        return count;
    }
}
