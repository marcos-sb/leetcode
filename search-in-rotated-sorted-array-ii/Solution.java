class Solution {
    public boolean search(int[] nums, int target) {
        final var N = nums.length;
        var lo = 0;
        var hi = N-1;
        while (lo <= hi) {
            final var mid = lo + (hi-lo)/2;
            if (nums[mid] == target) return true;
            
            // This is to handle the case of duplicate elements.
            //
            // If both conditions hold, we don't know which half is sorted,
            // and since we know `nums[mid] != target`, we can safely shrink
            // the search space and check again in the next iteration.
            //
            // This additional condition degrades the overall run time complexity
            // from log to linear in the worst case.
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                lo++; hi--;
            } else if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) hi = mid-1;
                else lo = mid+1;
            } else {
                if (nums[mid] < target && target <= nums[hi]) lo = mid+1;
                else hi = mid-1;
            }
        }
        return false;
    }
}
