class Solution {
    private static final int[][] moves = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public void solve(char[][] board) {
        final var M = board.length;
        final var N = board[0].length;
        final var visited = new boolean[M][N];
        for (var r = 0; r < M; r++)
            for (var c = 0; c < N; c++)
                tryCapture(board, r, c, visited);
    }
    
    private static void tryCapture(char[][] board, int r, int c, boolean[][] visited) {
        if (board[r][c] == 'X' || visited[r][c]) return;
        
        final var group = new ArrayList<Integer>();
        final var capture = new boolean[]{true};
        getGroup(board, r, c, group, visited, capture);
        if (capture[0]) doCapture(board, group);
    }
    
    private static void getGroup(char[][] board, int r, int c, List<Integer> group, boolean[][] visited, boolean[] capture) {
        final var N = board[0].length;
        if (board[r][c] == 'X' || visited[r][c]) return;
        visited[r][c] = true;
        group.add(r*N+c);
        
        for (var m : moves) {
            final var newR = r+m[0];
            final var newC = c+m[1];
            if (!isValid(board, newR, newC)) {
                capture[0] = false;
                continue;
            }
            getGroup(board, newR, newC, group, visited, capture);
        }
    }
    
    private static boolean isValid(char[][] board, int r, int c) {
        return !(r < 0 || c < 0 || board.length <= r || board[0].length <= c);
    }
    
    private static void doCapture(char[][] board, List<Integer> group) {
        final var N = board[0].length;
        for (var index : group) {
            final var r = index / N;
            final var c = index % N;
            board[r][c] = 'X';
        }
    }
}
