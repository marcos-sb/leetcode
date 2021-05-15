class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        final var sets = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            final var str = strs[i];
            final var zeros = count(str, '0');
            final var ones = str.length() - zeros;
            sets[i] = new int[]{zeros, ones};
        }
        
        final int[][][] cache = new int[strs.length][m+1][n+1];
        for (int i = 0; i < cache.length; i++)
            for (int j = 0; j < cache[0].length; j++)
                for (int k = 0; k < cache[0][0].length; k++)
                    cache[i][j][k] = -1;
        
        return dfs(sets, 0, m, n, cache);
    }
    
    private static int count(String strs, char c) {
        int count = 0;
        for (int i = 0; i < strs.length(); i++)
            if (strs.charAt(i) == c) count++;
        return count;
    }
    
    private static int dfs(int[][] sets, int i, int m, int n, int[][][] cache) {
        if (m < 0 || n < 0) return -1;
        if (m+n == 0 || i == sets.length) return 0;
        
        if (cache[i][m][n] != -1) return cache[i][m][n];
        
        final var set = sets[i];
        int maxSetSize = dfs(sets, i+1, m, n, cache);
        final var sizeWithSet = 1 + dfs(sets, i+1, m-set[0], n-set[1], cache);
        maxSetSize = Math.max(maxSetSize, sizeWithSet);
        
        if (cache[i][m][n] == -1) cache[i][m][n] = maxSetSize;
        
        return maxSetSize;
    }
}
