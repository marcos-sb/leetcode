public class Solution {
    private static int[][] movs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (board.length == 0 || board[0].length == 0)
            return word.isEmpty();
        
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (word.charAt(0) == board[r][c] &&
                    dfs(board, r, c, 1, word, new boolean[board.length][board[0].length]))
                    return true;
            }
        }

        return false;
    }
    
    private static boolean dfs(char[][] board, int r, int c, int i, String w, boolean[][] visited) {
        if (i == w.length()) return true;
        
        visited[r][c] = true;
        for (int[] mov : movs) {
            final int newR = mov[0] + r;
            final int newC = mov[1] + c;
            if (invalid(board, newR, newC) || w.charAt(i) != board[newR][newC] || visited[newR][newC])
                continue;
            if (dfs(board, newR, newC, i+1, w, visited)) return true;
        }
        visited[r][c] = false;

        return false;
    }

    private static boolean invalid(char[][] board, int r, int c) {
        return r < 0 || c < 0 || r >= board.length || c >= board[0].length;
    }
}
