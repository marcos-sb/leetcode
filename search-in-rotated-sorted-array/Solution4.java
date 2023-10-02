class Solution {
    public int search(int[] nums, int target) {
        final var N = nums.length;
        var lo = 0;
        var hi = N-1;
        while (lo <= hi) {
            final var mid = lo + (hi-lo)/2;
            if (nums[mid] == target) return mid;
            else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) hi = mid-1;
                else lo = mid+1;
            } else {
                if (nums[mid] < target && target <= nums[hi]) lo = mid+1;
                else hi = mid-1;
            }
        }
        
        return -1;
    }
}