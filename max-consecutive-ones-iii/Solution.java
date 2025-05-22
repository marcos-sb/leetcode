class Solution {
    public int longestOnes(int[] nums, int k) {
        final var n = nums.length;
        var left = 0;
        var maxLen = 0;
        for (var right = 0; right < n; ++right) {
            if (nums[right] == 0) {
                --k;
            }
            while (k < 0) {
                if (nums[left] == 0) {
                    ++k;
                }
                ++left;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }

        return maxLen;
    }
}
