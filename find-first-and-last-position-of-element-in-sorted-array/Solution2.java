class Solution {
    public int[] searchRange(int[] nums, int target) {
        final var res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    private static int findLeft(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length-1;
        var left = -1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (target < nums[mid]) hi = mid-1;
            else if (nums[mid] < target) lo = mid+1;
            else {
                left = mid;
                hi = mid-1;
            }
        }
        return left;
    }

    private static int findRight(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length-1;
        var right = -1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            if (target < nums[mid]) hi = mid-1;
            else if (nums[mid] < target) lo = mid+1;
            else {
                right = mid;
                lo = mid+1;
            }
        }
        return right;
    }
}
