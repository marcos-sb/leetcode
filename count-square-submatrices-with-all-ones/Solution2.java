class Solution {
    public int countSquares(int[][] matrix) {
        final var M = matrix.length;
        final var N = matrix[0].length;
        for (var i = 0; i < M; ++i) {
            for (var j = 0; j < N; ++j) {
                if (matrix[i][j] == 0) continue;
                var left = 0;
                if (0 < j) left = matrix[i][j-1];
                var topleft = 0;
                if (0 < j && 0 < i) topleft = matrix[i-1][j-1];
                var top = 0;
                if (0 < i) top = matrix[i-1][j];
                matrix[i][j] = Math.min(left, Math.min(topleft, top)) + 1;
            }
        }

        var count = 0;
        for (var i = 0; i < M; ++i) {
            for (var j = 0; j < N; ++j) {
                count += matrix[i][j];
            }
        }

        return count;
    }
}
