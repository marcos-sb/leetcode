class Solution {
  private static final int[][] movs = {{1,0},{0,1}};

  public int uniquePaths(int rows, int cols) {
    if (rows <= 0 || cols <= 0) return 0;
    return dfs(rows, cols, 0, 0, new int[rows][cols]);
  }

  private static int dfs(int rows, int cols, int r, int c, int[][] cache) {
    if (r == rows-1 && c == cols-1) {
      return 1;
    }

    if (cache[r][c] != 0) return cache[r][c];

    var paths = 0;
    for (var mov : movs) {
      final var newR = r + mov[0];
      final var newC = c + mov[1];
      if (invalid(rows, cols, newR, newC)) continue;
      paths += dfs(rows, cols, newR, newC, cache);
    }

    return cache[r][c] = paths;
  }

  private static boolean invalid(int rows, int cols, int r, int c) {
    return r < 0 || r >= rows || c < 0 || c >= cols;
  }
}
