class Solution {
    public void setZeroes(int[][] matrix) {
        final var M = matrix.length;
        final var N = matrix[0].length;

        // This solution uses the first row and the first col to mark
        // if there's a zero along that row or col. The problem is we
        // have to use an additional variable to store if there was a
        // zero in the first col (or row). This is because matrix[0][0],
        // when used in the way we have described, is shared between rows
        // and cols. So if we didn't use an additional variable, we
        // wouldn't know if there was a zero in the first col or first row.
        // In this solution `matrix[0][0]` stores whether there was a
        // zero in the first row.

        // Check if there's a zero in the first col
        var firstCol = false;
        for (var r = 0; r < M; r++)
            if (matrix[r][0] == 0) {
                firstCol = true;
                break;
            }
        
        // Skip the first col, and mark the first cell of a row and col
        // with a zero whenever we find a zero in that submatrix
        for (var r = 0; r < M; r++) {
            for (var c = 1; c < N; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        // Skip the first row and col. We cannot set zeros in those yet
        // or we'll lose the markings.
        // Set zero to every cell in the submatrix where the first row or col
        // has been marked zero in the previous step
        for (var r = 1; r < M; r++) {
            for (var c = 1; c < N; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                    matrix[r][c] = 0;
            }
        }

        // Set the first row to zero if needed
        if (matrix[0][0] == 0)
            for (var c = 1; c < N; c++)
                matrix[0][c] = 0;
        
        // Set the first col to zero if needed
        if (firstCol)
            for (var r = 0; r < M; r++)
                matrix[r][0] = 0;
    }
}
