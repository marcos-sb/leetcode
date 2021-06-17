class Solution {
  private static final int[][] movs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
  
  public int[][] paint(int[][] image, int row, int col, int newColor) {
    if (image == null || image.length == 0 || image[0].length == 0)
      return image;
    if (invalid(image, row, col)) return image;

    final var oldColor = image[row][col];
    if (oldColor == newColor) return image;

    final var q = new ArrayDeque<int[]>();
    image[row][col] = newColor;
    q.offer(new int[]{row, col});

    while (!q.isEmpty()) {
      final var curr = q.poll();
      for (var mov : movs) {
        final var newRow = curr[0] + mov[0];
        final var newCol = curr[1] + mov[1];
        if (invalid(image, newRow, newCol) || image[newRow][newCol] != oldColor)
          continue;
        image[newRow][newCol] = newColor;
        q.offer(new int[]{newRow, newCol});
      }
    }

    return image;
  }

  private static boolean invalid(int[][] image, int r, int c) {
    return r < 0 || c < 0 || image.length <= r || image[0].length <= c;
  }
}
