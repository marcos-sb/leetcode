class Solution {
    public void rotate(int[][] matrix) {
        final var N = matrix.length;
        for (var j = 0; j < N/2; j++)
            for (var i = j; i < N-1-j; i++) {
                var tmp = matrix[i][N-1-j];
                matrix[i][N-1-j] = matrix[j][i];
                var tmp2 = matrix[N-1-j][N-1-i];
                matrix[N-1-j][N-1-i] = tmp;
                tmp = matrix[N-1-i][j];
                matrix[N-1-i][j] = tmp2;
                matrix[j][i] = tmp;
            }
    }
}
