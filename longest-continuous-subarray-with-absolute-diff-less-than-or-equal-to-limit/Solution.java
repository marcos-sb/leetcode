class Solution {
    public int longestSubarray(int[] nums, int limit) {
        final var n = nums.length;
        final var windowCounts = new TreeMap<Integer, Integer>();
        var left = 0;
        var maxLen = 0;
        for (var right = 0; right < n; ++right) {
            final var numR = nums[right];
            windowCounts.put(numR, windowCounts.getOrDefault(numR, 0) + 1);

            while (limit < windowCounts.lastKey() - windowCounts.firstKey()) {
                final var numL = nums[left];
                windowCounts.put(numL, windowCounts.getOrDefault(numL, 0) - 1);
                if (windowCounts.get(numL) == 0) {
                    windowCounts.remove(numL);
                }
                ++left;
            }

            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
