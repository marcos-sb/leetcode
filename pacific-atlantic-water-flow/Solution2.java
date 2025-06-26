class Solution {
    private static final int[][] moves = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final var m = heights.length;
        final var n = heights[0].length;

        final var visited = new int[m][n];
        final List<List<Integer>> res = new ArrayList<>();
        for (var r = 0; r < m; ++r) dfs(heights, r, 0, visited, 1, res);
        for (var c = 1; c < n; ++c) dfs(heights, 0, c, visited, 1, res);

        for (var r = 0; r < m; ++r) dfs(heights, r, n-1, visited, 2, res);
        for (var c = 0; c < n-1; ++c) dfs(heights, m-1, c, visited, 2, res);

        return res;
    }

    private void dfs(int[][] h, int r, int c, int[][] visited, int ocean, List<List<Integer>> res) {
        if (visited[r][c] == ocean) return;
        if (0 < visited[r][c]) res.add(List.of(r,c));
        visited[r][c] = ocean;

        for (var move : moves) {
            final var newR = r + move[0];
            final var newC = c + move[1];
            if (!outside(h, newR, newC) && h[r][c] <= h[newR][newC] && visited[newR][newC] != ocean)
                dfs(h, newR, newC, visited, ocean, res);
        }
    }

    private boolean outside(int[][] h, int r, int c) {
        return r < 0 || c < 0 || h.length <= r || h[0].length <= c;
    }
}
