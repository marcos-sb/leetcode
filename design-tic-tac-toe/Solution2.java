class TicTacToe {
    private final int[] rows;
    private final int[] cols;
    private int diag;
    private int antiDiag;
    
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        final int change = player == 1 ? 1 : -1;
        rows[row] += change;
        cols[col] += change;
        if (row == col) diag += change;
        final int n = rows.length-1;
        if (n-row == col) antiDiag += change;
        if (checkWin(row, col)) return player;
        return 0;
    }
    
    private boolean checkWin(int row, int col) {
        final int n = rows.length;
        return Math.abs(rows[row]) >= n || Math.abs(cols[col]) >= n ||
            Math.abs(diag) >= n || Math.abs(antiDiag) >= n;
    }
}

