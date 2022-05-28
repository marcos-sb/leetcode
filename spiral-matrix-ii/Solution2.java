class Solution {
    public int[][] generateMatrix(int n) {
        final var res = new int[n][n];
        var top = 0;
        var right = n-1;
        var bottom = n-1;
        var left = 0;
        
        var counter = 1;
        while (top <= bottom) {
            for (var c = left; c <= right; c++)
                res[top][c] = counter++;
            top++;
            for (var r = top; r <= bottom; r++)
                res[r][right] = counter++;
            right--;
            for (var c = right; c >= left; c--)
                res[bottom][c] = counter++;
            bottom--;
            for (var r = bottom; r >= top; r--)
                res[r][left] = counter++;
            left++;
        }
        
        return res;
    }
}
