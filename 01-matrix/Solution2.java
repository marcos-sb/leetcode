class Solution {
    public int[][] updateMatrix(int[][] mat) {
        final var M = mat.length;
        final var N = mat[0].length;
        final var dp = new int[M][N];

        // Top-left to bottom-right traversal.
        // Calculate the minimum distance to a zero-cell by visiting the top and left cells
        // of a given cell, taking the minimum, and adding 1.
        for (var r = 0; r < M; r++) {
            for (var c = 0; c < N; c++) {
                if (mat[r][c] == 0) continue;
                // Integer.MAX_VALUE - 8 is to prevent int overflow (and wrap around) when adding 1.
                // Integer.MAX_VALUE - 8 is also the max recommended size for an array in Java. 
                // https://github.com/openjdk/jdk14u/blob/84917a040a81af2863fddc6eace3dda3e31bf4b5/src/java.base/share/classes/jdk/internal/util/ArraysSupport.java#L577
                final var left = c == 0 ? Integer.MAX_VALUE - 8: dp[r][c-1];
                final var top = r == 0 ? Integer.MAX_VALUE - 8: dp[r-1][c];
                dp[r][c] = 1 + Math.min(left, top);
            }
        }

        // Repeat the same idea, but with an inverted traversal strategy.
        // That is: bottom-right to top-left visiting bottom and right
        // neighbouring cells of a given cell.
        for (var r = M-1; 0 <= r; r--) {
            for (var c = N-1; 0 <= c; c--) {
                if (mat[r][c] == 0) continue;
                final var right = c == N-1 ? Integer.MAX_VALUE - 8 : dp[r][c+1];
                final var bottom = r == M-1 ? Integer.MAX_VALUE - 8 : dp[r+1][c];
                dp[r][c] = Math.min(dp[r][c], 1 + Math.min(right, bottom));
            }
        }

        return dp;
    }
}
