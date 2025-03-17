class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        final var N = matrix.length;
        var lo = matrix[0][0];
        var hi = matrix[N-1][N-1];

        while (lo < hi) {
            final var mid = (hi-lo) / 2 + lo;
            var c = N-1;
            var count = 0;
            for (var r = 0; r < N; r++) {
                while (0 <= c && mid < matrix[r][c]) {
                    --c;
                }
                count += c + 1;
            }
            if (count < k) lo = mid+1;
            else hi = mid;
        }

        return lo;
    }
}
