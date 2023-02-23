class Solution {
    private static final int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final var m = heights.length;
        final var n = heights[0].length;

        final var pacific = new HashSet<Integer>();
        for (var r = 0; r < m; r++) dfs(heights, n, r, 0, pacific);
        for (var c = 0; c < n; c++) dfs(heights, n, 0, c, pacific);

        final var atlantic = new HashSet<Integer>();
        for (var r = 0; r < m; r++) dfs(heights, n, r, n-1, atlantic);
        for (var c = 0; c < n; c++) dfs(heights, n, m-1, c, atlantic);

        pacific.retainAll(atlantic);

        final List<List<Integer>> res = new ArrayList<>();
        for (var pos : pacific) {
            final var r = pos / n;
            final var c = pos % n;
            res.add(List.of(r, c));
        }

        return res;
    }

    private static void dfs(int[][] heights, int n, int r, int c, HashSet<Integer> seen) {
        final var pos = r*n + c;
        if (seen.contains(pos)) return;
        seen.add(pos);
        
        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            final var newPos = newR * n + newC;
            if (isValid(heights, newR, newC) && !seen.contains(newPos) && heights[r][c] <= heights[newR][newC])
                dfs(heights, n, newR, newC, seen);
        }
    }

    private static boolean isValid(int[][] heights, int r, int c) {
        return !(r < 0 || c < 0 || heights.length <= r || heights[0].length <= c);
    }
}
