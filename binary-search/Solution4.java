class Solution {
    public int search(int[] nums, int target) {
        return rec(nums, target, 0, nums.length-1);
    }

    private static int rec(int[] nums, int target, int lo, int hi) {
        if (hi < lo) return -1;
        final var mid = (hi-lo)/2 + lo;
        if (nums[mid] < target)
            return rec(nums, target, mid+1, hi);
        if (target < nums[mid])
            return rec(nums, target, lo, mid-1);
        return mid;
    }
}
