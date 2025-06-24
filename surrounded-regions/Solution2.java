class Solution {
    private static final int[][] moves = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        final var m = board.length;
        final var n = board[0].length;
        if (m < 3 || n < 3) return;

        final var visited = new boolean[m][n];
        final var safe = new boolean[m][n];
        for (var j = 0; j < n; ++j) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j, safe, visited);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j, safe, visited);
            }
        }

        for (var i = 0; i < m; ++i) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, safe, visited);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1, safe, visited);
            }
        }

        for (var i = 1; i < m-1; ++i) {
            for (var j = 1; j < n-1; ++j) {
                if (safe[i][j]) continue;
                board[i][j] = 'X';
            }
        }
    }

    private static void dfs(char[][] board, int r, int c, boolean[][] safe, boolean[][] visited) {
        if (visited[r][c]) return;
        safe[r][c] = true;
        visited[r][c] = true;

        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            if (invalid(board, newR, newC) || visited[newR][newC] || board[newR][newC] != 'O') continue;
            dfs(board, newR, newC, safe, visited);
        }
    }

    private static boolean invalid(char[][] board, int r, int c) {
        return r < 0 || c < 0 || board.length <= r || board[0].length <= c;
    }
}
