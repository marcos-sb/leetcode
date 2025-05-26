class Solution {
    public boolean isValidSudoku(char[][] board) {
        final var n = 9;
        final Set<Integer>[] rows = new Set[n];
        final Set<Integer>[] cols = new Set[n];
        final Set<Integer>[][] boxes = new Set[n/3][n/3];

        for (var i = 0; i < n; ++i) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (var i = 0; i < n/3; ++i) {
            for (var j = 0; j < n/3; ++j) {
                boxes[i][j] = new HashSet<>();
            }
        }

        for (var i = 0; i < n; ++i) {
            for (var j = 0; j < n; ++j) {
                final var numChar = board[i][j];
                if (numChar == '.') continue;
                final var num = numChar - '0';
                if (!rows[i].add(num) || !cols[j].add(num) || !boxes[i/3][j/3].add(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}
