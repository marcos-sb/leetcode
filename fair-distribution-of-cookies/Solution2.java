class Solution {
    public int distributeCookies(int[] cookies, int k) {
        final var n = cookies.length;
        final var dp = new int[k][1 << n];
        final var sum = new int[1 << n];
        for (var mask = 0; mask < (1 << n); ++mask) {
            var _sum = 0;
            for (var i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    _sum += cookies[i];
                }
            }
            sum[mask] = _sum;
        }

        for (var mask = 0; mask < (1 << n); ++mask) {
            dp[0][mask] = sum[mask];
        }

        for (var child = 1; child < k; ++child) {
            for (var mask = 0; mask < (1 << n); ++mask) {
                dp[child][mask] = Integer.MAX_VALUE;
                for (var subset = mask; 0 < subset; subset = (subset-1) & mask) {
                    final var max = Math.max(sum[subset], dp[child-1][subset^mask]);
                    dp[child][mask] = Math.min(max, dp[child][mask]);
                }
            }
        }

        return dp[k-1][(1 << n) - 1];
    }
}
