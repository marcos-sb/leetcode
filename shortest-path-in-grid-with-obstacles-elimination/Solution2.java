class Solution {
    private static int[][] movs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int shortestPath(int[][] grid, int k) {
        final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[4], b[4]);
        final var q = new PriorityQueue<int[]>(cmp);
        final var visited = new boolean[grid.length][grid[0].length][k+1];
        q.offer(new int[]{0,0,0,k,f(grid,0,0,0)});
        visited[0][0][k] = true;
        
        while (!q.isEmpty()) {
            final var cur = q.poll();
            if (cur[0] == grid.length-1 && cur[1] == grid[0].length-1)
                return cur[2];
            
            for (var mov : movs) {
                final var newR = cur[0] + mov[0];
                final var newC = cur[1] + mov[1];
                if (outside(grid, newR, newC)) continue;
                final var kLeft = grid[newR][newC] == 1 ? cur[3] - 1 : cur[3];
                if (kLeft < 0 || visited[newR][newC][kLeft]) continue;
                q.offer(new int[]{newR, newC, cur[2]+1, kLeft, f(grid,newR,newC,cur[2]+1)});
                visited[newR][newC][kLeft] = true;
            }
        }
        
        return -1;
    }
    
    private static int f(int[][] grid, int r, int c, int steps) {
        final var g = steps;
        final var h = distToEnd(grid, r, c); // heuristic
        return g + h;
    }
    
    private static int distToEnd(int[][] grid, int r, int c) {
        return grid.length - r + grid[0].length - c - 2;
    }
    
    private static boolean outside(int[][] grid, int r, int c) {
        return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
    }
}
