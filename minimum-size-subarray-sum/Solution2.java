class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final var n = nums.length;
        var left = 0;
        var sum = 0;
        var minLen = Integer.MAX_VALUE;
        for (var right = 0; right < n; ++right) {
            sum += nums[right];
            while (target <= sum) {
                minLen = Math.min(minLen, right-left+1);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
