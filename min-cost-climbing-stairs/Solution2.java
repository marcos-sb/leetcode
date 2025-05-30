class Solution {
    public int minCostClimbingStairs(int[] cost) {
        final var n = cost.length;
        for (var i = 2; i < n; ++i) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[n-1], cost[n-2]);
    }
}
