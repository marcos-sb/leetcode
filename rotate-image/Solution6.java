class Solution {
    public void rotate(int[][] matrix) {
        final var n = matrix.length;
        var top = 0;
        var left = 0;
        var bottom = n-1;
        var right = n-1;

        while (left < right) {
            for (var i = 0; i < right-left; ++i) {
                var tmp = matrix[top+i][right];
                matrix[top+i][right] = matrix[top][left+i];
                var tmp2 = matrix[bottom][right-i];
                matrix[bottom][right-i] = tmp;
                tmp = matrix[bottom-i][left];
                matrix[bottom-i][left] = tmp2;
                matrix[top][left+i] = tmp;
            }
            ++top; ++left; --bottom; --right;
        }
    }
}
