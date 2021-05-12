public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        int count = 0;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                count++;
                r++;
                c--;
            } else if (matrix[r][c] < target) r++;
            else c--;
        }
        return count;
    }
}
