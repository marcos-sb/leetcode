class Solution {
    public int[][] generateMatrix(int n) {
        final var ret = new int[n][n];
        var left = 0;
        var right = n-1;
        var k = 1;
        while (left < right) {
            for (var i = 0; i < right-left; i++)
                ret[left][left+i] = k++;
            for (var i = 0; i < right-left; i++)
                ret[left+i][right] = k++;
            for (var i = 0; i < right-left; i++)
                ret[right][right-i] = k++;
            for (var i = 0; i < right-left; i++)
                ret[right-i][left] = k++;
            left++; right--;
        }
        
        // mid element for mats w/ odd dims
        if (n % 2 == 1)
            ret[left][right] = k;
        
        return ret;
    }
}
