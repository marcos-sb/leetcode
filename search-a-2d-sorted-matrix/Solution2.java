class Solution2 {
  public boolean search2(int[][] matrix, int target) {
    if (matrix == null) return false;
    int l = 0;
    int r = matrix.length * matrix[0].length - 1;
    while (l <= r) {
      int mid = (r-l)/2 + l;
      int row = mid / matrix[0].length;
      int col = mid % matrix[0].length;
      if (matrix[row][col] < target) {
        l = mid+1;
      } else if (target < matrix[row][col]) {
        r = mid-1;
      } else return true;
    }
    return false;
  }
}
