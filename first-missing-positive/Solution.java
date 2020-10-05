class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] < 0) nums[i] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            final int n = nums[i];
            if (n == 0 || nums.length < n) continue;
            final int idx = Math.abs(n) - 1;
            if (0 < nums[idx]) nums[idx] *= -1;
            else if (0 == nums[idx]) nums[idx] = -(idx+1);
        }
        
        for (int i = 0; i < nums.length; i++)
            if (0 <= nums[i]) return i+1;
        
        return nums.length + 1;
    }
}
