class Solution {
    public int[] productExceptSelf(int[] nums) {
        final var N = nums.length;
        final var left = new int[N];
        final var right = new int[N];
        
        left[0] = nums[0];
        for (var i = 1; i < N; i++)
            left[i] = left[i-1] * nums[i];
        right[N-1] = nums[N-1];
        for (var i = N-2; i >= 0; i--)
            right[i] = nums[i] * right[i+1];
        
        nums[0] = right[1];
        nums[N-1] = left[N-2];
        for (var i = 1; i < N-1; i++)
            nums[i] = left[i-1] * right[i+1];
        
        return nums;
    }
}
