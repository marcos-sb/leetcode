class Solution {
    private static final int[][] movs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    
    public int getFood(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        
        final var start = findStart(grid);
        if (start == null) return -1;
        
        return shortestPathToFoodLen(grid, start);
    }
    
    private static int[] findStart(char[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '*') return new int[]{r,c};
            }
        }
        return null;
    }
    
    private static int shortestPathToFoodLen(char[][] grid, int[] start) {
        final var C = grid[0].length;
        final var q = new LinkedList<Integer>();
        
        int dist = 0;
        q.offer(start[0]*C+start[1]);
        while (!q.isEmpty()) {
            var size = q.size();
            while (size-- > 0) {
                final var curr = q.poll();
                final var r = curr/C;
                final var c = curr%C;
                
                for (var mov : movs) {
                    final var newR = r+mov[0];
                    final var newC = c+mov[1];
                    if (outside(grid, newR, newC) ||
                        grid[newR][newC] == 'X' ||
                        grid[newR][newC] == '*') continue;
                    if (grid[newR][newC] == '#') return dist+1;
                    grid[newR][newC] = 'X';
                    q.offer(newR*C+newC);
                }
            }
            dist++;
        }
        
        return -1;
    }
    
    private static boolean outside(char[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
    }
}
