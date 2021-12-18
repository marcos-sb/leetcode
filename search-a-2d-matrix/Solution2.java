class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        var n = matrix.length;
        var m = matrix[0].length;
        
        var lo = 0;
        var hi = n*m-1;
        while (lo <= hi) {
            final var mid = (hi-lo)/2 + lo;
            final var r = mid/m;
            final var c = mid%m;
            
            if (matrix[r][c] < target) lo = mid+1;
            else if (target < matrix[r][c]) hi = mid-1;
            else return true;
        }
        
        return false;
    }
}
