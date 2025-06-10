class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final var m = matrix.length;
        final var n = matrix[0].length;

        var left = 0;
        var right = n*m-1;
        while (left <= right) {
            final var mid = left + (right-left) / 2;
            final var r = mid / n;
            final var c = mid % n;
            if (target == matrix[r][c]) {
                return true;
            }
            if (target < matrix[r][c]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return false;
    }
}
