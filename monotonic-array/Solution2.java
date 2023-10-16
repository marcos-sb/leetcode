class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) return true;
        return increasing(nums) || decreasing(nums);
    }

    private static boolean increasing(int[] nums) {
        for (var i = 1; i < nums.length; i++)
            if (nums[i-1] > nums[i]) return false;
        return true;
    }

    private static boolean decreasing(int[] nums) {
        for (var i = 1; i < nums.length; i++)
            if (nums[i-1] < nums[i]) return false;
        return true;
    }
}
