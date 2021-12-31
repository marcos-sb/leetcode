class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final var N = matrix.length;
        final var M = matrix[0].length;
        var r = 0;
        var c = M-1;
        while (0 <= r && 0 <= c && r < N && c < M) {
            if (matrix[r][c] < target) r++;
            else if (target < matrix[r][c]) c--;
            else return true;
        }
        
        return false;
    }
}
