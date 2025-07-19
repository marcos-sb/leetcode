class Solution {
    public int jump(int[] nums) {
        final var n = nums.length;
        var jumps = 0;
        var end = 0;
        var farthest = 0;

        for (var i = 0; i < n-1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                ++jumps;
                end = farthest;
                if (n-1 <= end) break;
            }
        }

        return jumps;
    }
}
