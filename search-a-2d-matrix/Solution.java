class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] > target) break;
                if (matrix[r][c] == target) return true;
            }
        }
        return false;
    }
}
