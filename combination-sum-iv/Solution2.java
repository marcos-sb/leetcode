class Solution2 {
    public int combinationSum4(int[] nums, int target) {
        final var cache = new int[target+1];
        cache[0] = 1;
        for (int i = 1; i <= target; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++)
                if (i - nums[j] >= 0) count += cache[i-nums[j]];
            cache[i] = count;
        }
        return cache[target];
    }
}
