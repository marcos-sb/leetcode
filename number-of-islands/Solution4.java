class Solution {
    private static final int[][] moves = new int[][]{{1,0},{-1,0},{0,1}, {0,-1}};

    public int numIslands(char[][] grid) {
        var count = 0;
        for (var r = 0; r < grid.length; r++) {
            for (var c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    ++count;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {
        if (invalid(grid, r, c) || grid[r][c] == '0') return;
        grid[r][c] = '0';

        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            dfs(grid, newR, newC);
        }
    }

    private static boolean invalid(char[][] grid, int r, int c) {
        return r < 0 || c < 0 || grid.length <= r || grid[0].length <= c;
    }
}
