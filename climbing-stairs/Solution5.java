class Solution {
    public int climbStairs(int n) {
        var _0 = 0; var _1 = 1;
        for (var i = 1; i <= n; i++) {
            final var tmp = _1;
            _1 += _0;
            _0 = tmp;
        }
        return _1;
    }
}
