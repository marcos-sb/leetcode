class Solution {
    public void rotate(int[][] matrix) {
        final var N = matrix.length;
        var left = 0;
        var right = N-1;
        
        while (left < right) {
            for (var i = 0; i < right-left; i++) {
                var tmp = matrix[left+i][right];
                matrix[left+i][right] = matrix[left][left+i];
                var tmp2 = matrix[right][right-i];
                matrix[right][right-i] = tmp;
                tmp = matrix[right-i][left];
                matrix[right-i][left] = tmp2;
                matrix[left][left+i] = tmp;
            }
        
            left++; right--;
        }
    }
}
