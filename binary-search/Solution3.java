class Solution {
    public int search(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (nums[mid] < target) lo = mid+1;
            else if (target < nums[mid]) hi = mid-1;
            else return mid;
        }
        return -1;
    }
}
