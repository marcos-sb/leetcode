class Solution {
    private static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        final var oldColor = image[sr][sc];
        if (color == oldColor) return image;
        floodFill(image, sr, sc, oldColor, color);
        return image;
    }

    private static void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        for (var m : moves) {
            final var newR = sr + m[0];
            final var newC = sc + m[1];
            if (isValid(image, newR, newC) && image[newR][newC] == oldColor)
                floodFill(image, newR, newC, oldColor, newColor);
        }
    }

    private static boolean isValid(int[][] image, int r, int c) {
        return !(r < 0 || c < 0 || image.length <= r || image[0].length <= c);
    }
}
