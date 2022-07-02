class Solution {
    private static final int[][] moves = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean exist(char[][] board, String word) {
        final var M = board.length;
        final var N = board[0].length;
        for (var r = 0; r < M; r++) {
            for (var c = 0; c < N; c++) {
                if (board[r][c] == word.charAt(0) &&
                    find(board, r, c, word, 0)) return true;
            }
        }
        
        return false;
    }

    private static boolean find(char[][] board, int r, int c, String s, int i) {
        if (i == s.length()) return true;
        if (!isValid(board, r, c) || board[r][c] == '0') return false;
        if (board[r][c] != s.charAt(i)) return false;
        
        final var mem = board[r][c];
        
        board[r][c] = '0';
        for (var m : moves) {
            final var newR = r+m[0];
            final var newC = c+m[1];
            if (find(board, newR, newC, s, i+1)) {
                board[r][c] = mem;
                return true;
            }
        }
        board[r][c] = mem;
        
        return false;
    }
    
    private static boolean isValid(char[][] board, int r, int c) {
        return !(r < 0 || c < 0 || board.length <= r || board[0].length <= c);
    }
}
