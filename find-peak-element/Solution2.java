class Solution {
    public int findPeakElement(int[] nums) {
        final var N = nums.length;
        if (N == 1 || nums[0] > nums[1]) return 0;
        if (nums[N-2] < nums[N-1]) return N-1;
        
        var lo = 1;
        var hi = N-2;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) return mid;
            if (nums[mid] <= nums[mid+1]) lo = mid+1;
            else hi = mid-1;
        }
        
        return lo;
    }
}
