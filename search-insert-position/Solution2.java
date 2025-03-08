class Solution {
    public int searchInsert(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (target < nums[mid]) hi = mid-1;
            else if (nums[mid] < target) lo = mid+1;
            else if (nums[mid] == target) return mid;
        }
        return lo;
    }
}
