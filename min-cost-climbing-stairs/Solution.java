class Solution {
    public int minCostClimbingStairs(int[] cost) {
        final var n = cost.length;
        var _0 = cost[0];
        var _1 = cost[1];
        for (var i = 2; i < n; i++) {
            final var tmp = _1;
            _1 = Math.min(_0, _1) + cost[i];
            _0 = tmp;
        }
        return Math.min(_0, _1);
    }
}
