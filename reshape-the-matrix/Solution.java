class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r*c != mat.length * mat[0].length)
            return mat;
        
        final var ret = new int[r][c];
        var rOut = 0; var cOut = 0;
        
        for (var rIn = 0; rIn < mat.length; rIn++)
            for (var cIn = 0; cIn < mat[0].length; cIn++) {
                if (cOut >= c) {
                    cOut = 0; rOut++;
                }
                ret[rOut][cOut++] = mat[rIn][cIn];
            }
        
        return ret;
    }
}
