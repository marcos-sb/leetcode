class Solution {
    private static final int[][] moves = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        final var q = new ArrayDeque<int[]>();
        var fresh = 0;

        for (var r = 0; r < grid.length; ++r) {
            for (var c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 2) q.offer(new int[]{r,c});
                else if (grid[r][c] == 1) ++fresh;
            }
        }

        if (fresh == 0) return 0;

        var minutes = -1;
        while (!q.isEmpty()) {
            var size = q.size();
            while (0 < size--) {
                final var rotten = q.poll();
                for (var m : moves) {
                    final var newR = rotten[0] + m[0];
                    final var newC = rotten[1] + m[1];
                    if (invalid(grid, newR, newC) || grid[newR][newC] != 1) continue;
                    grid[newR][newC] = 2;
                    --fresh;
                    q.offer(new int[]{newR, newC});
                }
            }
            ++minutes;
        }

        return fresh == 0 ? minutes : -1;
    }

    private static boolean invalid(int[][] grid, int r, int c) {
        return r < 0 || c < 0 || grid.length <= r || grid[0].length <= c;
    }
}
