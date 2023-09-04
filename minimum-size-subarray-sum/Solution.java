class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final var N = nums.length;
        var minLen = Integer.MAX_VALUE;
        var sum = 0;
        var l = 0;
        var r = 0;
        while (r < N) {
            sum += nums[r];
            while (target <= sum && l <= r) {
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l++];
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
