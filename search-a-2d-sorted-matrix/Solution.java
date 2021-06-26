class Solution {
  public boolean search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    
    int row = 0;
    int l = 0;
    int r = matrix[0].length-1;
    while (row < matrix.length && r >= 0) {
      if (target < matrix[row][l]) return false;
      if (matrix[row][r] < target) row++;
      else if (target < matrix[row][r]) r--;
      else return true;
    }
    
    return false;
  }
}
