class Solution {
    static final int[][] deltas = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        
        final var M = grid.length;
        final var N = grid[0].length;
        var count = 0;
        for (var r = 0; r < M; r++)
            for (var c = 0; c < N; c++)
                if (grid[r][c] == '1') {
                    count++;
                    markIsland(grid, r, c);
                }
        
        return count;
    }
    
    private static void markIsland(char[][] grid, int r, int c) {
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';
        for (var d : deltas) {
            final var newR = r + d[0];
            final var newC = c + d[1];
            if (isValid(grid, newR, newC)) markIsland(grid, newR, newC);
        }
    }
    
    private static boolean isValid(char[][] grid, int r, int c) {
        return !(r < 0 || c < 0 || grid.length <= r || grid[0].length <= c);
    }
}
