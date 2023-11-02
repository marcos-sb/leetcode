class Solution {
    public List<List<String>> solveNQueens(int n) {
        final var cols = new boolean[n]; // queen at col
        final var queens = new int[n];   // queen at: {i <- row, queens[i] <- col}
        Arrays.fill(queens, -1);

        final List<List<String>> res = new ArrayList<>();
        bt(0, cols, queens, res);

        return res;
    }

    private static void bt(int r, boolean[] cols, int[] queens, List<List<String>> res) {
        if (r == queens.length) {
            res.add(toString(queens));
            return;
        }

        for (var c = 0; c < cols.length; c++) {
            if (isValid(r, c, cols, queens)) { // O(n^2)
                cols[c] = true;
                queens[r] = c;
                bt(r+1, cols, queens, res);
                cols[c] = false;
                queens[r] = -1;
            }
        }
    }

    private static List<String> toString(int[] queens) { // O(n^2)
        final var res = new ArrayList<String>();
        for (var i = 0; i < queens.length; i++) { // O(n^2)
            final var sb = new StringBuilder();
            for (var j = 0; j < queens.length; j++) { // O(n)
                if (queens[i] == j) sb.append('Q');
                else sb.append('.');
            }
            res.add(sb.toString()); // O(n)
        }
        return res;
    }

    private static boolean isValid(int r, int c, boolean[] cols, int[] queens) { // O(n)
        if (cols[c]) return false;
        for (var i = 0; i < queens.length; i++) {
            if (r - i < 0 || c - i < 0) break;
            if (queens[r-i] == c-i) return false;
        }
        for (var i = 1; i < queens.length; i++) {
            if (r - i < 0 || cols.length <= c + i) break;
            if (queens[r-i] == c+i) return false;
        }
        return true;
    }
}
