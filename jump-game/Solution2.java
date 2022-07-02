class Solution {
    public boolean canJump(int[] nums) {
        final var N = nums.length;
        
        var reach = N-1;
        for (var i = N-2; 0 <= i; i--)
            if (reach <= i + nums[i]) reach = i;
        
        return reach == 0;
    }
}
