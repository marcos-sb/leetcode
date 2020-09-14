class Solution {
    public int rob(int[] nums) {
        final var cache = new int[2][nums.length];
        for (int i = 0; i < 2; i++) Arrays.fill(cache[i], -1);
        return rob(nums, 0, 0, cache);
    }
    
    private static int rob(int[] nums, int i, int robbedPrev, int[][] cache) {
        if (i >= nums.length) return 0;
        if (cache[robbedPrev][i] >= 0) return cache[robbedPrev][i];
        if (robbedPrev == 0)
            cache[0][i] = Math.max(nums[i] + rob(nums, i+1, 1, cache), rob(nums, i+1, 0, cache));
        else cache[1][i] = rob(nums, i+1, 0, cache);
        return cache[robbedPrev][i];
    }
}
