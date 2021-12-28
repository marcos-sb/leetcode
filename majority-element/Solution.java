class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        var count = 0;
        var candidate = nums[0];
        for (var n : nums) {
            if (count == 0) candidate = n;
            count += (n == candidate) ? 1 : -1;
        }
        
        return candidate;
    }
}
