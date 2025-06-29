class Solution {

    private final int[][] moves = new int[][] {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 },
    };

    public int shortestPath(int[][] grid, int k) {
        final var m = grid.length;
        final var n = grid[0].length;
        final var visited = new boolean[m][n][k + 1];
        final var queue = new ArrayDeque<int[]>();

        int startEliminations = k;
        if (grid[0][0] == 1) {
            --startEliminations;
            if (startEliminations < 0) return -1;
        }

        queue.offer(new int[] { 0, 0, startEliminations });
        visited[0][0][startEliminations] = true;

        var steps = 0;
        while (!queue.isEmpty()) {
            var level = queue.size();
            while (0 < level--) {
                final var curr = queue.poll();
                final var r = curr[0];
                final var c = curr[1];
                final var eliminations = curr[2];

                if (r == m - 1 && c == n - 1) return steps;

                for (var move : moves) {
                    final var newR = curr[0] + move[0];
                    final var newC = curr[1] + move[1];
                    if (outside(grid, newR, newC)) continue;

                    var newEliminations = eliminations;
                    if (
                        grid[newR][newC] == 1 && --newEliminations < 0
                    ) continue;

                    if (visited[newR][newC][newEliminations]) continue;

                    visited[newR][newC][newEliminations] = true;
                    queue.offer(new int[] { newR, newC, newEliminations });
                }
            }
            ++steps;
        }

        return -1;
    }

    private static boolean outside(int[][] grid, int r, int c) {
        return r < 0 || c < 0 || grid.length <= r || grid[0].length <= c;
    }
}
