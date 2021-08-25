class Solution {
    private static int[][] movs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    maxArea = Math.max(islandArea(grid, r, c), maxArea);
            }
        }
        return maxArea;
    }
    
    private static int islandArea(int[][] grid, int r, int c) {
        if (outside(grid, r, c) || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        
        int area = 1;
        for (var mv : movs) {
            final var newR = r + mv[0];
            final var newC = c + mv[1];
            area += islandArea(grid, newR, newC);
        }
        return area;
    }
    
    private static boolean outside(int[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
    }
}
