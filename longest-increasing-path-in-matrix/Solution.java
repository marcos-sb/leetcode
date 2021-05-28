class Solution {
    private static final int[][] movs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    
    public static int longestIncreasingPath(int[][] matrix) {
        final int[][] cache = new int[matrix.length][matrix[0].length];
        var maxLen = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                maxLen = Math.max(maxLen, dfs(matrix, r, c, cache));
            }
        }
        return maxLen;
    }
    
    private static int dfs(int[][] matrix, int r, int c, int[][] cache) {
        if (notValid(matrix, r, c)) return 0;
        if (cache[r][c] > 0) return cache[r][c];
        
        int maxLen = 1;
        for (var mov : movs) {
            final var newR = mov[0] + r;
            final var newC = mov[1] + c;
            if (notValid(matrix, newR, newC) || matrix[r][c] >= matrix[newR][newC]) continue;
            maxLen = Math.max(maxLen, 1 + dfs(matrix, newR, newC, cache));
        }
        
        if (cache[r][c] == 0) cache[r][c] = maxLen;
        
        return maxLen;
    }
    
    private static boolean notValid(int[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length;
    }
}
