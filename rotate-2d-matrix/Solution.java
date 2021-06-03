class Solution {
  public int[][] rotate(int[][] matrix) {
    if (matrix == null) return null;
    if (matrix.length == 1) return matrix;
    // 00 -> 03 -> 33 -> 30 -> 00
    // 01 -> 13 -> 32 -> 20 -> 01
    // 02 -> 23 -> 31 -> 10 -> 02
    // 11 -> 12 -> 22 -> 21 -> 11
    var rows = matrix.length;
    var cols = matrix[0].length;
    for (var r = 0; r < rows/2; r++) {
      for (var c = r; c < cols-r-1; c++) {
        var tmp = matrix[c][cols-r-1];
        matrix[c][cols-r-1] = matrix[r][c];
        var tmp2 = matrix[cols-r-1][rows-c-1];
        matrix[cols-r-1][rows-c-1] = tmp;
        tmp = tmp2;
        tmp2 = matrix[rows-c-1][r];
        matrix[rows-c-1][r] = tmp;
        matrix[r][c] = tmp2;
      }
    }
    return matrix;
  }
}
