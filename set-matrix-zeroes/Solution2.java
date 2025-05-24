class Solution {
    public void setZeroes(int[][] matrix) {
        final var m = matrix.length;
        final var n = matrix[0].length;

        var firstColZero = false;
        for (var i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        var firstRowZero = false;
        for (var i = 0; i < n; ++i) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (var i = 1; i < m; ++i) {
            for (var j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (var i = 1; i < m; ++i) {
            if (matrix[i][0] == 0) {
                for (var j = 1; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (var i = 1; i < n; ++i) {
            if (matrix[0][i] == 0) {
                for (var j = 1; j < m; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstColZero) {
            for (var i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowZero) {
            for (var i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }
    }
}
