class Solution {
  public int countInversions(int[] A) {
    if (A == null || A.length <= 1) return 0;
    return inversions(A, 0, A.length-1, new int[A.length]);
  }

  private static int inversions(int[] A, int lo, int hi, int[] aux) {
    if (hi <= lo) return 0;
    final int mid = (hi-lo)/2 + lo;
    final int left = inversions(A, lo, mid, aux);
    final int right = inversions(A, mid+1, hi, aux);
    return left + right + count(A, lo, mid, hi, aux);
  }

  private static int count(int[] A, int lo, int mid, int hi, int[] aux) {
    if (hi <= lo) return 0;
    int i = lo;
    int j = mid+1;
    int inversions = 0;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) aux[k] = A[j++];
      else if (j > hi) aux[k] = A[i++];
      else if (A[i] <= A[j]) aux[k] = A[i++];
      else {
        inversions += mid+1-i;
        aux[k] = A[j++];
      }
    }

    for (int k = lo; k <= hi; k++)
      A[k] = aux[k];
    
    return inversions;
  }
}
