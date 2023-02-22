class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final var m = matrix.length;
        final var n = matrix[0].length;
        var hi = m*n - 1;
        var lo = 0;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            final var r = mid / n;
            final var c = mid % n;
            if (target < matrix[r][c]) hi = mid-1;
            else if (matrix[r][c] < target) lo = mid+1;
            else return true;
        }
        return false;
    }
}
