class Solution {
  public boolean validSudoku(int[][] board) {
    final var seen = new HashSet<String>();
    for (var r = 0; r < board.length; r++) {
      for (var c = 0; c < board[0].length; c++) {
        final var v = board[r][c];
        if (v == 0) continue;
        final String rs = v + "(" + r + ")";
        final String cs = "(" + c + ")" + v;
        final String gs = "(" + r/3 + ")" + "(" + c/3 + ")" + v;
        if (seen.contains(rs) || seen.contains(cs) || seen.contains(gs))
          return false;
        seen.add(rs); seen.add(cs); seen.add(gs);
      }
    }
    return true;
  }  
}
