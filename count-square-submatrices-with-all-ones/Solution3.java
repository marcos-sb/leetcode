class Solution {
    public int countSquares(int[][] matrix) {
        final var M = matrix.length;
        final var N = matrix[0].length;

        for (var i = 1; i < M; ++i) {
            for (var j = 1; j < N; ++j) {
                if (matrix[i][j] == 0) continue;
                matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1])) + 1;
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
