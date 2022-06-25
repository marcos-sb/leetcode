class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        final var N = nums.length;
        var l = 0;
        var r = 0;
        var minLen = Integer.MAX_VALUE;
        var sum = 0;
        while (r < N) {
            sum += nums[r];
            while (target <= sum && l <= r) {
                if (l == r) return 1;
                minLen = Math.min(minLen, r-l+1);
                sum -= nums[l++];
            }
            r++;
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
