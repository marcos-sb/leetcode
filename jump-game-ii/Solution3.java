class Solution {
    public int jump(int[] nums) {
        final var N = nums.length;
        var index = 0;
        var reach = 0;
        var jumps = 0;
        while (reach < N-1) {
            final var maxReach = maxReach(nums, index, reach);
            index = reach;
            reach = maxReach;
            jumps++;
        }
        return jumps;
    }

    private static int maxReach(int[] nums, int lo, int hi) {
        final var N = nums.length;
        var reach = lo;
        for (var j = lo; j <= hi; j++) {
            reach = Math.max(j + nums[j], reach);
        }
        return Math.min(reach, N-1);
    }
}
