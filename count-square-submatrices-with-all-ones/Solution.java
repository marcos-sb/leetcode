class Solution {
    public int countSquares(int[][] matrix) {
        var res = 0;
        for (var r = 0; r < matrix.length; r++) {
            for (var c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] > 0 && r > 0 && c > 0)
                    matrix[r][c] = Math.min(Math.min(matrix[r-1][c-1], matrix[r-1][c]), matrix[r][c-1]) + 1;
                res += matrix[r][c];
            }
        }
        return res;
    }
}
