class Solution {
    public int[] findBall(int[][] grid) {
        final var M = grid.length;
        final var N = grid[0].length;
        final var res = new int[N];
        for (var i = 0; i < N; i++) {
            var r = 0;
            var c = i;
            while (r < M) {
                if (grid[r][c] == 1) {
                    if (c+1 == N || grid[r][c+1] == -1) {
                        c = -1;
                        break;
                    }
                    c++;
                } else if (grid[r][c] == -1) {
                    if (c-1 < 0 || grid[r][c-1] == 1) {
                        c = -1;
                        break;
                    }
                    c--;
                }
                r++;
            }
            res[i] = c;
        }
        return res;
    }
}
