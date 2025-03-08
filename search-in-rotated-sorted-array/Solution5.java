class Solution {
    public int search(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (target == nums[mid]) return mid;
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) hi = mid-1;
                else lo = mid+1;
            } else if (nums[mid] <= nums[hi]) {
                if (nums[mid] < target && target <= nums[hi]) lo = mid+1;
                else hi = mid-1;
            }
        }
        return -1;
    }
}
