class Solution {
    public int[] findBall(int[][] grid) {
        final var n = grid[0].length;
        final var res = new int[n];
        for (var c = 0; c < n; c++)
            res[c] = findBall(grid, c);
        return res;
    }

    private static int findBall(int[][] grid, int c) {
        var r = 0;
        while (isValid(grid, r, c)) {
            if (grid[r][c] == 1) {
                c++;
                if (!isValid(grid, r, c) || grid[r][c] == -1) return -1;
                r++;
            } else {
                c--;
                if (!isValid(grid, r, c) || grid[r][c] == 1) return -1;
                r++;
            }
        }
        return r == grid.length ? c : -1;
    }

    private static boolean isValid(int[][] grid, int r, int c) {
        return !(r < 0 || c < 0 || grid.length <= r || grid[0].length <= c);
    }    
}
