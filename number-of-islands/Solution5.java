class Solution {
    private static final int[][] moves = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int numIslands(char[][] grid) {
        final var m = grid.length;
        final var n = grid[0].length;

        var count = 0;
        for (var i = 0; i < m; ++i) {
            for (var j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ++count;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '2';

        for (var move : moves) {
            final var newRow = r + move[0];
            final var newCol = c + move[1];
            if (invalid(grid, newRow, newCol) || grid[newRow][newCol] != '1') continue;
            dfs(grid, newRow, newCol);
        }
    }

    private static boolean invalid(char[][] grid, int r, int c) {
        return r < 0 || c < 0 || grid.length <= r || grid[0].length <= c;
    }
}
