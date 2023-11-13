class Solution {
    private static final int[][] moves = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};

    public boolean exist(char[][] board, String word) {
        final var M = board.length;
        final var N = board[0].length;
        for (var r = 0; r < M; r++)
            for (var c = 0; c < N; c++)
                if (bt(r, c, board, 0, word)) return true;
        return false;
    }

    private static boolean bt(int r, int c, char[][] board, int i, String word) {
        if (board[r][c] != word.charAt(i)) return false;
        if (i+1 == word.length()) return true;
        
        final var mem = board[r][c];
        board[r][c] = '.';

        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            if (!isValid(newR, newC, board)) continue;
            final var exists = bt(newR, newC, board, i+1, word);
            if (exists) return true;
        }
        board[r][c] = mem;

        return false;
    }

    private static boolean isValid(int r, int c, char[][] board) {
        return !(r < 0 || c < 0 || board.length <= r || board[0].length <= c);
    }
}
