class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        final var N = nums.length;
        var lo = 0;
        var hi = N-1;
        if (nums[hi] < nums[lo]) {
            final var pivot = findMaxIdx(nums);
            if (target <= nums[hi]) lo = Math.min(pivot+1, hi);
            else hi = pivot;
        }
        
        final var res = Arrays.binarySearch(nums, lo, hi+1, target);
        return res < 0 ? -1 : res;
    }
    
    private static int findMaxIdx(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        
        var lo = 0;
        var hi = nums.length-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (nums[mid+1] < nums[mid]) return mid;
            if (nums[mid] < nums[lo]) hi = mid-1;
            else lo = mid+1;
        }
        
        return 0;
    }
}
