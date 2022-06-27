class Solution {
    private static int[][] moves = new int[][]{
        {-1,0},{1,0},{1,1},{-1,-1},{0,-1},{0,1},{1,-1},{-1,1} 
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid[0][0] == 1) return -1;
        final var N = grid.length;
        final var q = new ArrayDeque<Integer>();
        q.offer(0);
        grid[0][0] = -1;
        while (!q.isEmpty()) {
            final var curr = q.poll();
            final var r = curr/N;
            final var c = curr%N;
            if (r == N-1 && c == N-1) break;
            for (var m : moves) {
                final var newR = r+m[0];
                final var newC = c+m[1];
                if (isValid(N, newR, newC) && grid[newR][newC] == 0) {
                    grid[newR][newC] = grid[r][c] - 1;
                    q.offer(newR*N+newC);
                }
            }
        }
        return grid[N-1][N-1] < 0 ? -grid[N-1][N-1] : -1;
    }
    
    private static boolean isValid(int N, int r, int c) {
        return !(r < 0 || c < 0 || N <= r || N <= c);
    }
}
