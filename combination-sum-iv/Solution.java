class Solution {
    public int combinationSum4(int[] nums, int target) {
        final var cache = new int[target+1];
        Arrays.fill(cache, -1);
        return dp(nums, target, cache);
    }
    
    private static int dp(int[] nums, int target, int[] cache) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        
        if (cache[target] != -1) return cache[target];
        
        int count = 0;
        for (int i = 0; i < nums.length; i++)
            count += dp(nums, target-nums[i], cache);
        
        return cache[target] = count;
    }
}
