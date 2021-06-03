class Solution {
  public int[][] rotate(int[][] matrix) {
    if (matrix == null) return null;
    if (matrix.length == 1) return matrix;
    // 00 -> 03 -> 33 -> 30 -> 00
    // 01 -> 13 -> 32 -> 20 -> 01
    // 02 -> 23 -> 31 -> 10 -> 02
    // 11 -> 12 -> 22 -> 21 -> 11
    var rows = matrix.length-1;
    var cols = matrix[0].length-1;
    
    for (int i = 0; i < (rows+1)/2; i++) {
      var one = new int[]{i,i};
      var two = new int[]{one[0],cols-one[1]};
      var three = new int[]{rows-one[0],cols-one[1]};
      var four = new int[]{rows-one[0],one[1]};
      for (int j = i; j < cols-i; j++) {
        var tmp = matrix[one[0]][one[1]];
        matrix[one[0]][one[1]] = matrix[four[0]][four[1]];
        matrix[four[0]][four[1]] = matrix[three[0]][three[1]];
        matrix[three[0]][three[1]] = matrix[two[0]][two[1]];
        matrix[two[0]][two[1]] = tmp;

        one[1]++;
        two[0]++;
        three[1]--;
        four[0]--;
      }
    }
    return matrix;
  }
}
