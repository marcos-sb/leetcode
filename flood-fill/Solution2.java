class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (image[r][c] != oldColor || image[r][c] == newColor) return;
        image[r][c] = newColor;
        
        if (r > 0) dfs(image, r-1, c, oldColor, newColor);
        if (c > 0) dfs(image, r, c-1, oldColor, newColor);
        if (r < image.length-1) dfs(image, r+1, c, oldColor, newColor);
        if (c < image[0].length-1) dfs(image, r, c+1, oldColor, newColor);
    }
}
