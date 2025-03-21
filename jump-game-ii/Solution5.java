class Solution {
    public int jump(int[] nums) {
        final var N = nums.length;
        var jumps = 0;
        var end = 0;
        var farthest = 0;

        for (var i = 0; i < N-1; ++i) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                ++jumps;
                end = farthest;
                if (N-1 <= farthest) break;
            }
        }

        return jumps;
    }
}
