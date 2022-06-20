class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        
        final var N = matrix.length;
        final var M = matrix[0].length;
        var lo = 0;
        var hi = N*M-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            final var r = mid / M;
            final var c = mid % M;
            if (target < matrix[r][c]) hi = mid-1;
            else if (matrix[r][c] < target) lo = mid+1;
            else return true;
        }
        
        return false;
    }
}
