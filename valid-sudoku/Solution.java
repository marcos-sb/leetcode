class Solution {
  public boolean validSudoku(int[][] board) {
    for (var r = 0; r < board.length; r++) {
      if (!validRow(board, r)) return false;
    }
    for (var c = 0; c < board[0].length; c++) {
      if (!validCol(board, c)) return false;
    }
    for (var r = 0; r < board.length; r += 3) {
      for (var c = 0; c < board[0].length; c += 3) {
        if (!validSubGrid(board, r, c)) return false;
      }
    }
    return true;
  }

  private static boolean validRow(int[][] board, int r) {
    final var seen = new HashSet<Integer>();
    for (int c = 0; c < board[0].length; c++) {
      final var n = board[r][c];
      if (n == 0) continue;
      if (seen.contains(n)) return false;
      seen.add(n);
    }
    return true;
  }

  private static boolean validCol(int[][] board, int c) {
    final var seen = new HashSet<Integer>();
    for (int r = 0; r < board.length; r++) {
      final var n = board[r][c];
      if (n == 0) continue;
      if (seen.contains(n)) return false;
      seen.add(n);
    }
    return true;
  }

  private static boolean validSubGrid(int[][] board, int r, int c) {
    final var seen = new HashSet<Integer>();
    for (var ri = 0; ri < 3; ri++) {
      for (var ci = 0; ci < 3; ci++) {
        final var n = board[r+ri][c+ci];
        if (n == 0) continue;
        if (seen.contains(n)) return false;
        seen.add(n);
      }
    }
    return true;
  }
}
