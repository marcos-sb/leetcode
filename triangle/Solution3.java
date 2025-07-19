class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        final var n = triangle.size();
        // if (n == 1) return triangle.get(0).get(0);

        var prev = new int[n];
        var curr = new int[n];
        prev[0] = triangle.get(0).get(0);

        for (var i = 1; i < n; ++i) {
            final var triangleRow = triangle.get(i);
            final var m = triangleRow.size();
            for (var j = 0; j <= i; ++j) {
                final var num = triangleRow.get(j);
                if (0 < j && j < m-1)
                    curr[j] = Math.min(prev[j-1] + num, prev[j] + num);
                else if (0 == j)
                    curr[j] = prev[j] + num;
                else if (j == m-1)
                    curr[j] = prev[j-1] + num;
            }

            final var tmp = prev;
            prev = curr;
            curr = tmp;
        }

        var min = Integer.MAX_VALUE;
        for (var num : prev)
            min = Math.min(num, min);

        return min;
    }
}
