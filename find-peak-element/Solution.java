class Solution {
    public int findPeakElement(int[] nums) {
        final var N = nums.length;
        if (nums == null || N == 0) return -1;
        if (N == 1) return 0;
        
        var lo = 0;
        var hi = N-1;
        while (lo < hi) {
            final var mid = (hi-lo)/2 + lo;
            if (nums[mid] <= nums[mid+1]) lo = mid+1;
            else hi = mid;
        }
        
        return lo;
    }
}

