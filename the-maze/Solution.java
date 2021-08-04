class Solution {
    private static final int[][] movs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination);
    }
    
    private static boolean dfs(int[][] maze, int[] start, int[] end) {
        if (maze[start[0]][start[1]] == 2) return false;
        if (start[0] == end[0] && start[1] == end[1]) return true;
        
        maze[start[0]][start[1]] = 2; // visited
        for (var m : movs) {
            final var newStart = moveBall(maze, start, m);
            if (maze[newStart[0]][newStart[1]] == 2) continue;
            if (dfs(maze, newStart, end)) return true;
        }
        
        return false;
    }
    
    private static int[] moveBall(int[][] maze, int[] start, int[] mov) {
        int r = start[0];
        int c = start[1];
        
        while (true) {
            r += mov[0];
            c += mov[1];
            if (outside(maze, r, c) || maze[r][c] == 1) {
                r -= mov[0];
                c -= mov[1];
                break;
            }
        }
        
        return new int[]{r,c};
    }
    
    private static boolean outside(int[][] maze, int r, int c) {
        return r < 0 || c < 0 || r >= maze.length || c >= maze[0].length;
    }
}
