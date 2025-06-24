class Solution {
    private static final int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        final var m = board.length;
        final var n = board[0].length;
        if (m < 3 || n < 3) return;

        for (var j = 0; j < n; ++j) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for (var i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }

        for (var i = 0; i < m; ++i) {
            for (var j = 0; j < n; ++j) {
                if (board[i][j] == 'S')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int r, int c) {
        board[r][c] = 'S';

        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            if (invalid(board, newR, newC) || board[newR][newC] != 'O') continue;
            dfs(board, newR, newC);
        }
    }

    private static boolean invalid(char[][] board, int r, int c) {
        return r < 0 || c < 0 || board.length <= r || board[0].length <= c;
    }
}
