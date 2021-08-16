class Solution {
    private static final int[][] movs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null)
            return false;
        
        if (word.isEmpty()) return true;
        
        for (var r = 0; r < board.length; r++) {
            for (var c = 0; c < board[0].length; c++) {
                if (dfs(board, r, c, word, 0)) return true;
            }
        }
        
        return false;
    }
    
    private static boolean dfs(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) return true;
        if (outside(board, r, c)) return false;
        
        final var ch = word.charAt(i);
        if (board[r][c] == '*' || board[r][c] != ch) return false;
        
        board[r][c] = '*';
        for (var mov : movs) {
            final var newR = r + mov[0];
            final var newC = c + mov[1];
            if (dfs(board, newR, newC, word, i+1)) return true;
        }
        board[r][c] = ch;
        
        return false;
    }
    
    private static boolean outside(char[][] board, int r, int c) {
        return r < 0 || c < 0 || r >= board.length || c >= board[0].length;
    }
}
