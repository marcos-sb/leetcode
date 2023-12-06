class Solution {
    public int climbStairs(int n) {
        var n_1 = 1;
        var n_2 = 1;
        for (var i = 2; i <= n; i++) {
            final var _n = n_1 + n_2;
            final var tmp = n_1;
            n_1 = _n;
            n_2 = tmp;
        }
        return n_1;
    }
}
