class Solution {
    private static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final var oldColor = image[sr][sc];
        if (color == oldColor) return image;
        
        final var cols = image[0].length;
        final var q = new LinkedList<Integer>();
        q.offer(sr*cols + sc);
        while (!q.isEmpty()) {
            final var cur = q.poll();
            final var r = cur / cols;
            final var c = cur % cols;
            image[r][c] = color;
            for (var m : moves) {
                final var newR = r + m[0];
                final var newC = c + m[1];
                if (isValid(image, newR, newC) && image[newR][newC] == oldColor)
                    q.offer(newR*cols + newC);
            }
        }

        return image;
    }

    private static boolean isValid(int[][] image, int r, int c) {
        return !(r < 0 || c < 0 || image.length <= r || image[0].length <= c);
    }
}
