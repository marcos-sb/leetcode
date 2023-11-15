class Solution {
    public void solveSudoku(char[][] board) {
        final var seen = loadSeen(board);
        bt(0, 0, board, seen);
    }

    private static Set<String> loadSeen(char[][] board) { // O(9*9)
        final var seen = new HashSet<String>(9*9*3); // row * col * 3
        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                final var val = board[r][c];
                if (val == '.') continue;
                final var row = String.format("(%d)%d", r, val-'0');
                final var col = String.format("%d(%d)", val-'0', c);
                final var box = String.format("(%d)(%d)%d", r/3, c/3, val-'0');
                seen.add(row); seen.add(col); seen.add(box);
            }
        }
        return seen;
    }

    private static boolean bt(int r, int c, char[][] board, Set<String> seen) { // O(9 ^ 9*9)
        if (c == 9) return true; // {r == 0, c == 9} <- nextCell(8, 8)

        if (board[r][c] != '.') {
            final var newRC = nextCell(r, c);
            return bt(newRC[0], newRC[1], board, seen);
        }

        for (var i = 1; i <= 9; i++) {
            final var row = String.format("(%d)%d", r, i);
            if (seen.contains(row)) continue;
            final var col = String.format("%d(%d)", i, c);
            if (seen.contains(col)) continue;
            final var box = String.format("(%d)(%d)%d", r/3, c/3, i);
            if (seen.contains(box)) continue;

            seen.add(row); seen.add(col); seen.add(box);
            board[r][c] = (char)(i+'0');

            final var newRC = nextCell(r, c);
            if (bt(newRC[0], newRC[1], board, seen)) return true;
            board[r][c] = '.';
            seen.remove(row); seen.remove(col); seen.remove(box);
        }

        return false;
    }

    private static int[] nextCell(int r, int c) {
        if (r < 8) r++;
        else { r = 0; c++; }
        return new int[]{r, c};
    }
}
