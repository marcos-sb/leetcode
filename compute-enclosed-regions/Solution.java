class Solution {
  private static int[][] movs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

  public char[][] computeEnclosedRegions(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return board;
    
    final boolean[][] visited = new boolean[board.length][board[0].length];
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (!visited[r][c] && board[r][c] != 'X')
          dfs(board, r, c, visited, onEdge(board, r, c));
      }
    }

    return board;
  }

  private static boolean onEdge(char[][] board, int r, int c) {
    return r == 0 || c == 0 || r == board.length-1 || c == board[0].length-1;
  }

  private static boolean dfs(char[][] board, int r, int c, boolean[][] visited, boolean onEdge) {
    visited[r][c] = true;
    
    onEdge |= onEdge(board, r, c);
    for (int[] mov : movs) {
      final int newR = r + mov[0];
      final int newC = c + mov[1];
      if (invalid(board,newR, newC) || visited[newR][newC] || board[newR][newC] == 'X') continue;
      visited[newR][newC] = true;
      onEdge |= dfs(board, newR, newC, visited, onEdge);
    }
    
    if (!onEdge) board[r][c] = 'X';
    
    return onEdge;
  }

  private static boolean invalid(char[][] board, int r, int c) {
    return r < 0 || c < 0 || r >= board.length || c >= board[0].length;
  }
}
