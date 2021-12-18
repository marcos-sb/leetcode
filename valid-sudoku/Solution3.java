class Solution3 {
    public boolean isValidSudoku(char[][] board) {
        final var set = new HashSet<String>(81);
        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                final var value = board[r][c];
                if (value == '.') continue;
                
                final var byRow = String.format("%d(%c)", r, value);
                final var byCol = String.format("(%d)%c", c, value);
                final var bySquare = String.format("(%d)(%c)", r/3*3 + c/3, value);
                
                if (set.contains(byRow) || set.contains(byCol) || set.contains(bySquare))
                    return false;
                
                set.add(byRow);
                set.add(byCol);
                set.add(bySquare);
            }
        }
        return true;
    }
}
