class Solution {
  public int[][] mergeOverlappingIntervals(int[][] A) {
    if (A == null || A.length <= 1) return A;

    final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[0], b[0]);
    Arrays.sort(A, cmp);

    for (int[] a : A)
      System.out.print(Arrays.toString(a));

    final List<int[]> resl = new ArrayList<>(A.length);
    int[] prev = A[0];
    for (int i = 1; i < A.length; i++) {
      final int[] curr = A[i];
      if (curr[0] <= prev[1]) {
        prev[0] = Math.min(prev[0], curr[0]);
        prev[1] = Math.max(prev[1], curr[1]);
      } else {
        resl.add(prev);
        prev = curr;
      }
    }
    resl.add(prev);

    final int[][] res = new int[resl.size()][2];
    int k = 0;
    for (int[] interval : resl)
      res[k++] = interval;

    return res;
  }
}
