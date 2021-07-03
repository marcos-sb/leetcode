class Solution {
  private static int[][] movs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

  public int numberOfDistinctIslands(int[][] grid) {
    if (grid == null) return 0;
    
    final Set<String> islands = new HashSet<>();
    final StringBuilder sb = new StringBuilder();
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          dfs(grid, r, c, sb);
          islands.add(sb.toString());
        }
        sb.setLength(0);
      }
    }

    return islands.size();
  }

  private static void dfs(int[][] grid, int r, int c, StringBuilder sb) {
    grid[r][c] = 0;
    for (int i = 0; i < movs.length; i++) {
      final int[] m = movs[i];
      final int newr = r + m[0];
      final int newc = c + m[1];
      if (invalid(grid, newr, newc) || grid[newr][newc] != 1) continue;
      grid[newr][newc] = 0;
      sb.append(i);
      dfs(grid, newr, newc, sb);
    }
  }

  private static boolean invalid(int[][] grid, int r, int c) {
    return r < 0 || c < 0 || r >= grid.length || c >= grid[0].length;
  }
}
