class Solution {
    private static int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        final var m = grid.length;
        final var n = grid[0].length;
        var nonRotting = 0;
        final var q = new LinkedList<Integer>();
        for (var r = 0; r < m; r++)
            for (var c = 0; c < n; c++)
                if (grid[r][c] == 1) nonRotting++;
                else if (grid[r][c] == 2) q.offer(r*n+c);

        if (nonRotting == 0) return 0;
        var mins = -1;
        while (!q.isEmpty()) {
            mins++;
            var size = q.size();
            while (size-- > 0) {
                final var cur = q.poll();
                final var r = cur / n;
                final var c = cur % n;
                for (var move : moves) {
                    final var newR = r + move[0];
                    final var newC = c + move[1];
                    if (isValid(grid, newR, newC) && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        q.offer(newR*n + newC);
                        nonRotting--;
                    }
                }
            }
        }

        return nonRotting == 0 ? mins : -1;
    }

    private static boolean isValid(int[][] grid, int r, int c) {
        return !(r < 0 || c < 0 || grid.length <= r || grid[0].length <= c);
    }
}
