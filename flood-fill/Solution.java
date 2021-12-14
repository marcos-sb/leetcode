class Solution {
    private static final int[][] movs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final var srcColor = image[sr][sc];
        if (srcColor == newColor) return image;
        
        final var m = image.length;
        final var n = image[0].length;
        
        final var q = new LinkedList<Integer>();
        q.offer(sr*n + sc);
        while (!q.isEmpty()) {
            final var cur = q.poll();
            final var curR = cur / n;
            final var curC = cur % n;
            image[curR][curC] = newColor;
            for (var mov : movs) {
                final var newR = curR + mov[0];
                final var newC = curC + mov[1];
                if (invalid(image, newR, newC) || image[newR][newC] != srcColor || image[newR][newC] == newColor) continue;
                q.offer(newR*n + newC);
            }
        }
        
        return image;
    }
    
    private static boolean invalid(int[][] image, int r, int c) {
        return r < 0 || c < 0 || r >= image.length || c >= image[0].length;
    }
}
