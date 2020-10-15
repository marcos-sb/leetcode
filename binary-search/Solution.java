class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length-1);
    }
    
    private static int bs(int[] nums, int target, int lo, int hi) {
        if (hi < lo) return -1;
        final var mid = (hi-lo)/2 + lo;
        if (target < nums[mid]) return bs(nums, target, lo, mid-1);
        if (nums[mid] < target) return bs(nums, target, mid+1, hi);
        return mid;
    }
}
