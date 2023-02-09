class Solution {
    private static final int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int numIslands(char[][] grid) {
        var islands = 0;
        for (var r = 0; r < grid.length; r++)
            for (var c = 0; c < grid[0].length; c++)
                if (grid[r][c] == '1') {
                    islands++;
                    visitIsland(grid, r, c);
                }
        return islands;
    }

    private static void visitIsland(char[][] grid, int r, int c) {
        grid[r][c] = '2';
        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            if (isValid(grid, newR, newC) && grid[newR][newC] == '1')
                visitIsland(grid, newR, newC);
        }
    }

    private static boolean isValid(char[][] grid, int r, int c) {
        return !(r < 0 || c < 0 || grid.length <= r || grid[0].length <= c);
    }
}
