class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};
        
        final var lo = findEdge(nums, target, true);
        if (lo == -1) return new int[]{-1,-1};
        
        final var hi = findEdge(nums, target, false);
        
        return new int[]{lo, hi};
    }
    
    private static int findEdge(int[] nums, int target, boolean left) {
        if (nums.length == 0) return -1;
        
        var lo = 0;
        var hi = nums.length-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (target < nums[mid]) hi = mid-1;
            else if (nums[mid] < target) lo = mid+1;
            else {
                if (left) {
                    if (lo == mid || nums[mid-1] != target) return mid;
                    hi = mid-1;
                } else {
                    if (hi == mid || nums[mid+1] != target) return mid;
                    lo = mid+1;
                }
            }
        }
        
        return -1;
    }
}
