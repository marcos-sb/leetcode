/**
*
* dp[i][j] = points[i][j] + max(dp[i-1][k] - abs(j - k)) for all k in 0..n-1.
*
*-----------------------------------------------------------------------------------------------------------------------------
*
* To reduce the time complexity, we need a way to compute max(dp[i-1][k] - abs(j - k)) more efficiently than O(n) per cell. Here's the key insight:
*
* The expression dp[i-1][k] - abs(j - k) can be split into two cases based on the relationship between j and k:
*
* When k <= j: abs(j - k) = j - k. So, the expression becomes dp[i-1][k] + k - j.
*
* The term dp[i-1][k] + k is independent of j for a given k. Let's call this left_val[k] = dp[i-1][k] + k.
*
* Then, for a given j, the maximum in this case is max(left_val[k] for k <= j) - j.
*
* When k >= j: abs(j - k) = k - j. So, the expression becomes dp[i-1][k] - k + j.
*
* The term dp[i-1][k] - k is independent of j for a given k. Let's call this right_val[k] = dp[i-1][k] - k.
*
* Then, for a given j, the maximum in this case is max(right_val[k] for k >= j) + j.
*
* Thus, for each j, the maximum of dp[i-1][k] - abs(j - k) is the maximum of:
*
* max(left_val[k] for k <= j) - j
*
* max(right_val[k] for k >= j) + j
*/
class Solution {
    public long maxPoints(int[][] points) {
        final var M = points.length;
        final var N = points[0].length;

        var dp = new long[N];
        for (var j = 0; j < N; ++j) {
            dp[j] = points[0][j];
        }

        final var left = new long[N];
        final var maxLeftPreffix = new long[N];
        final var right = new long[N];
        final var maxRightSuffix = new long[N];
        final var newDp = new long[N];

        for (var i = 1; i < M; ++i) {
            for (var j = 0; j < N; ++j) {
                left[j] = dp[j] + j;
            }

            maxLeftPreffix[0] = left[0];
            for (var j = 1; j < N; ++j) {
                maxLeftPreffix[j] = Math.max(maxLeftPreffix[j-1], left[j]);
            }

            for (var j = 0; j < N; ++j) {
                right[j] = dp[j] - j;
            }

            maxRightSuffix[N-1] = right[N-1];
            for (var j = N-2; 0 <= j; --j) {
                maxRightSuffix[j] = Math.max(maxRightSuffix[j+1], right[j]);
            }

            for (var j = 0; j < N; ++j) {
                newDp[j] = points[i][j] + Math.max(maxLeftPreffix[j] - j, maxRightSuffix[j] + j);
            }
            dp = newDp;
        }

        long max = 0;
        for (var num : dp) {
            max = Math.max(max, num);
        }

        return max;
    }
}
