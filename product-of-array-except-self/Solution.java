class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) return nums;
        dp(nums, 0, 1);
        return nums;
    }
    
    private static int dp(int[] nums, int i, int lp) {
        if (i == nums.length) return 1;
        final int rp = dp(nums, i+1, nums[i]*lp);
        final int res = nums[i] * rp;
        nums[i] = lp*rp;
        return res;
    }
}
