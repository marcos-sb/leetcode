class Solution {
    private static final int[][] moves = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int colour) {
        final var originalColour = image[sr][sc];
        if (colour == originalColour) return image;
        
        dfs(image, sr, sc, colour, originalColour);
        
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int colour, int originalColour) {
        if (image[r][c] != originalColour) return;
        image[r][c] = colour;
        for (var m : moves) {
            final var newR = r + m[0];
            final var newC = c + m[1];
            if (!isValid(image, newR, newC)) continue;
            dfs(image, newR, newC, colour, originalColour);
        }
    }

    private static boolean isValid(int[][] image, int r, int c) {
        return !(r < 0 || c < 0 || image.length <= r || image[0].length <= c);
    }
}
