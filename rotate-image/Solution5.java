class Solution {
    public void rotate(int[][] matrix) {
        // Transpose + reverse = rotate 90 degrees clockwise
        final var N = matrix.length;
        for (var i = 0; i < N; i++) { // Transpose around the main diagonal
            for (var j = i+1; j < N; j++) {
                final var tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (var r = 0; r < N; r++) { // Horizontal reverse
            var i = 0;
            var j = N-1;
            while (i < j) {
                final var tmp = matrix[r][i];
                matrix[r][i] = matrix[r][j];
                matrix[r][j] = tmp;
                i++; j--;
            }
        }
    }
}
