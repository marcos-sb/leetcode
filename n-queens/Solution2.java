class Solution {
    public List<List<String>> solveNQueens(int n) {
        final var board = new boolean[n][n];
        final List<List<String>> res = new ArrayList<>();
        bt(board, 0, res);
        return res;
    }

    private static void bt(boolean[][] board, int row, List<List<String>> res) {
        if (row == board.length) {
            res.add(toResFormat(board));
            return;
        }

        for (var col = 0; col < board[0].length; ++col) {
            if (valid(board, row, col)) {
                board[row][col] = true;
                bt(board, row+1, res);
                board[row][col] = false;
            }
        }
    }

    private static List<String> toResFormat(boolean[][] board) {
        final var n = board.length;
        final var res = new ArrayList<String>(n);
        final var sb = new StringBuilder(n);
        for (var row = 0; row < n; ++row) {
            for (var col = 0; col < n; ++col) {
                if (board[row][col]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
            sb.setLength(0);
        }
        return res;
    }

    private static boolean valid(boolean[][] board, int row, int col) {
        final var n = board.length;

        for (var i = 0; i < row; ++i) {
            if (board[i][col]) return false;
        }

        for (int i = row-1, j = col-1; 0 <= i && 0 <= j; --i, --j) {
            if (board[i][j]) return false;
        }

        for (int i = row-1, j = col+1; 0 <= i && j < n; --i, ++j) {
            if (board[i][j]) return false;
        }

        return true;
    }
}
