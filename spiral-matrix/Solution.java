class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final var m = matrix.length;
        final var n = matrix[0].length;
        var top = 0;
        var right = n-1;
        var bottom = m-1;
        var left = 0;
        final var res = new ArrayList<Integer>();
        while (top <= bottom && left <= right) {
            for (var c = left; c <= right; c++) res.add(matrix[top][c]);
            top++;
            for (var r = top; r <= bottom; r++) res.add(matrix[r][right]);
            right--;
            if (top <= bottom)
                for (var c = right; left <= c; c--) res.add(matrix[bottom][c]);
            bottom--;
            if (left <= right)
                for (var r = bottom; top <= r; r--) res.add(matrix[r][left]);
            left++;
        }
        return res;
    }
}
