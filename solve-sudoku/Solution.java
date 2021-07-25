class Solution {
  private static final char EMPTY_ENTRY = '.';

  public char[][] solveSudoku(char[][] board) {
    final Set<String> used = new HashSet<>();
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        final char n = board[r][c];
        if (n == '.') continue;
        final String byRows = String.format("(%d)%c", r, n);
        final String byCols = String.format("%c(%d)", n, c);
        final String bySubGrid = String.format("(%d)%c(%d)", r/3, n, c/3);
        used.add(byRows); used.add(byCols); used.add(bySubGrid);
      }
    }
    
    solve(board, 0, 0, used);
    
    return board;
  }

  private static boolean solve(char[][] board, int r, int c, Set<String> used) {
    if (r == board.length-1 && c == board[0].length) return true;
    if (c == board[0].length) return solve(board, r+1, 0, used);
    if (board[r][c] != '.') return solve(board, r, c+1, used);
    
    for (int i = 1; i <= 9; i++) {
      if (isPresent(board, used, r, c, (char)(i+'0')))
        continue;
      final char n = (char)(i+'0');
      final String byRows = String.format("(%d)%c", r, n);
      final String byCols = String.format("%c(%d)", n, c);
      final String bySubGrid = String.format("(%d)%c(%d)", r/3, n, c/3);
      used.add(byRows); used.add(byCols); used.add(bySubGrid);
      board[r][c] = n;
      if (solve(board, r, c+1, used)) return true;
      used.remove(byRows); used.remove(byCols); used.remove(bySubGrid);
      board[r][c] = '.';
    }

    return false;
  }

  private static boolean isPresent(char[][] board, Set<String> used, int r, int c, char n) {
    final String byRows = String.format("(%d)%c", r, n);
    final String byCols = String.format("%c(%d)", n, c);
    final String bySubGrid = String.format("(%d)%c(%d)", r/3, n, c/3);
    return used.contains(byRows) || used.contains(byCols) || used.contains(bySubGrid);
  }
}
