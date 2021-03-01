class Solution {
    private static final int[][] moves = new int[][]{{1,1},{1,-1},{-1,-1},{-1,1},{1,0},{0,-1},{-1,0},{0,1}};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        return spbm(grid, 0, 0, grid.length-1, grid[0].length-1);
    }
    
    private static int spbm(int[][] grid, int srcR, int srcC, int dstR, int dstC) {
        if (!valid(grid, srcR, srcC)) return -1;
        
        final var q = new ArrayDeque<int[]>();
        q.offerLast(new int[]{srcR, srcC, 1});
        grid[srcR][srcC] = -1;
        while(!q.isEmpty()) {
            final var curr = q.pollFirst();
            
            if (curr[0] == dstR && curr[1] == dstC)
                return curr[2];
            
            for (var pos : moves(grid, curr[0], curr[1], curr[2])) {
                q.offerLast(pos);
                grid[pos[0]][pos[1]] = -1;
            }
        }
        
        return -1;
    }
    
    private static boolean valid(int[][] grid, int r, int c) {
        return !(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            && grid[r][c] == 0;
    }
    
    private static List<int[]> moves(int[][] grid, int r, int c, int currSteps) {
        final var res = new ArrayList<int[]>(moves.length);
        for (var move : moves) {
            final var pos = new int[]{r+move[0], c+move[1], currSteps+1};
            if (valid(grid, pos[0], pos[1]))
                res.add(pos);
        }
        
        return res;
    }
}
