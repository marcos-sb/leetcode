class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    final var rows = matrix.length;
    final var cols = matrix[0].length;
    final var res = new ArrayList<Integer>();
    var fenceR = cols-1;
    var fenceB = rows-1;
    var fenceL = 0;
    var fenceT = 0;
    while (fenceL <= fenceR && fenceT <= fenceB) {
      for (var c = fenceL; c <= fenceR; c++)
        res.add(matrix[fenceT][c]);
      fenceT++;
      for (var r = fenceT; r <= fenceB; r++)
        res.add(matrix[r][fenceR]);
      fenceR--;
      if (fenceT <= fenceB) 
        for (var c = fenceR; c >= fenceL; c--)
          res.add(matrix[fenceB][c]);
      fenceB--;
      if (fenceL <= fenceR)
        for (var r = fenceB; r >= fenceT; r--)
          res.add(matrix[r][fenceL]);
      fenceL++;
    }
    
    return res;
  }
}
