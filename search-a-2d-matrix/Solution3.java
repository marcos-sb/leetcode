class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        
        final var N = matrix.length;
        final var M = matrix[0].length;
        var r = 0;
        var c = M-1;
        while (0 <= r && 0 <= c && r < N && c < M) {
            if (target < matrix[r][c]) c--;
            else if (matrix[r][c] < target) r++;
            else return true;
        }
        
        return false;
    }
}
