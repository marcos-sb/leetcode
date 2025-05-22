class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final var m = matrix.length;
        final var n = matrix[0].length;
        var top = 0;
        var bottom = m-1;
        var left = 0;
        var right = n-1;

        final var res = new ArrayList<Integer>(m*n);
        while (left <= right && top <= bottom) {
            for (var i = left; i <= right; ++i) {
                res.add(matrix[top][i]);
            }
            ++top;

            for (var i = top; i <= bottom; ++i) {
                res.add(matrix[i][right]);
            }
            --right;

            if (top <= bottom) {
                for (var i = right; left <= i; --i) {
                    res.add(matrix[bottom][i]);
                }
                --bottom;
            }

            if (left <= right) {
                for (var i = bottom; top <= i; --i) {
                    res.add(matrix[i][left]);
                }
                ++left;
            }
        }

        return res;
    }
}
