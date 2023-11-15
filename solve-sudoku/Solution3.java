class Solution {
    private final boolean[][] rows;
    private final boolean[][] cols;
    private final boolean[][][] boxes;

    public Solution() {
        rows = new boolean[9][9];
        cols = new boolean[9][9];
        boxes = new boolean[3][3][9];
    }
    public void solveSudoku(char[][] board) {
        loadSeen(board);
        bt(0, 0, board);
    }

    private void loadSeen(char[][] board) { // O(9*9)
        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                final var val = board[r][c];
                if (val == '.') continue;
                final var i = val - '0' - 1;
                rows[r][i] = true;
                cols[c][i] = true;
                boxes[r/3][c/3][i] = true;
            }
        }
    }

    private boolean bt(int r, int c, char[][] board) { // O(9 ^ 9*9)
        if (c == 9) return true; // {r == 0, c == 9} <- nextCell(8, 8)

        if (board[r][c] != '.') {
            final var newRC = nextCell(r, c);
            return bt(newRC[0], newRC[1], board);
        }

        for (var i = 0; i < 9; i++) { // i <- 0 => board[r][c] <- i+1
            if (rows[r][i] || cols[c][i] || boxes[r/3][c/3][i]) continue;
            rows[r][i] = true;
            cols[c][i] = true;
            boxes[r/3][c/3][i] = true;

            board[r][c] = (char)(i+'1');

            final var newRC = nextCell(r, c);
            if (bt(newRC[0], newRC[1], board)) return true;
            board[r][c] = '.';
            rows[r][i] = false;
            cols[c][i] = false;
            boxes[r/3][c/3][i] = false;
        }

        return false;
    }

    private static int[] nextCell(int r, int c) {
        if (r < 8) r++;
        else { r = 0; c++; }
        return new int[]{r, c};
    }
}
