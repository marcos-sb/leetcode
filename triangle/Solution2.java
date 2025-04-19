class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        final var N = triangle.size();
        for (var i = 1; i < N; ++i) {
            final var size = triangle.get(i).size();
            final var prevRow = triangle.get(i-1);
            final var currRow = triangle.get(i);
            for (var j = 0; j < size; ++j) {
                var prevRowJ_1 = Integer.MAX_VALUE;
                var prevRowJ = Integer.MAX_VALUE;
                if (0 < j) {
                    prevRowJ_1 = prevRow.get(j-1);
                }
                if (j < size-1) {
                    prevRowJ = prevRow.get(j);
                }
                currRow.set(j, Math.min(prevRowJ, prevRowJ_1) + currRow.get(j));
            }
        }

        var min = Integer.MAX_VALUE;
        for (var sum : triangle.getLast()) {
            min = Math.min(min, sum);
        }

        return min;
    }
}
