class Solution {
    public int search(int[] nums, int target) {
        final var N = nums.length;
        var lo = 0;
        var hi = N-1;
        while (lo <= hi) {
            final var mid = lo + (hi-lo)/2;
            if (target < nums[mid]) hi = mid-1;
            else if (nums[mid] < target) lo = mid+1;
            else return mid;
        }
        return -1;
    }
}
