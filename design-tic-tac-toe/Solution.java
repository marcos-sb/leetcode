class TicTacToe {
    private final int[][] board;
    private final int n;
    private int moves;
    
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
        this.moves = 0;
    }
    
    public int move(int row, int col, int player) {
        moves++;
        board[row][col] = player;
        if (moves < n) return 0;
        final int diags = diagonals(row, col);
        if (diags != 0) return diags;
        return straights(row, col);
    }
    
    private int straights(int row, int col) {
        int player = board[row][col];
        int r = row;
        int c = col-1;
        int count = 1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            c--;
        }
        c = col+1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            c++;
        }
        c = col; r = row-1; count = 1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            r--;
        }
        r = row+1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            r++;
        }
        return 0;
    }
    
    private boolean valid(int r, int c, int player) {
        return r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == player;
    }
    
    private int diagonals(int row, int col) {
        int player = board[row][col];
        int r = row-1;
        int c = col-1;
        int count = 1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            r--; c--;
        }
        c = col+1; r = row+1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            r++; c++;
        }
        r = row+1; c = col-1; count = 1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            r++; c--;
        }
        r = row-1; c = col+1;
        while (valid(r,c,player)) {
            if (++count >= n) return player;
            r--; c++;
        }
        return 0;
    }
}

