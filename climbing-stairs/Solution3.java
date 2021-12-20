class Solution {
    public int climbStairs(int n) {
        var dp0 = 1; var dp1 = 1;
        
        for (var i = 2; i <= n; i++) {
            final var tmp = dp1;
            dp1 = dp0 + dp1;
            dp0 = tmp;
        }
        
        return dp1;
    }
}
