class Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        var max = 0;
        for (var r = 0; r < grid.length; r++)
            for (var c = 0; c < grid[0].length; c++)
                max = Math.max(max, dfs(grid, r, c));
        return max;
    }
    
    private static int dfs(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        
        var size = 1;
        if (r > 0) size += dfs(grid, r-1, c);
        if (c > 0) size += dfs(grid, r, c-1);
        if (r < grid.length-1) size += dfs(grid, r+1, c);
        if (c < grid[0].length-1) size += dfs(grid, r, c+1);
        
        return size;
    }
}
