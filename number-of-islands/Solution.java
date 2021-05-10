public class Solution {
    static final int[][] movs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(boolean[][] grid) {
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                islands += dfs(r, c, grid);
            }
        }
        return islands;
    }

    private static int dfs(int r, int c, boolean[][] grid) {
        if (!grid[r][c]) return 0;
        
        grid[r][c] = false;
        for (int[] mov : movs) {
            int newR = r + mov[0];
            int newC = c + mov[1];
            if (!isValid(newR,newC,grid) || !grid[newR][newC]) continue;
            dfs(newR,newC,grid);
        }

        return 1;
    }

    private static boolean isValid(int r, int c, boolean[][] grid) {
        return !(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length);
    }
}
