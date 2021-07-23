class Solution {
  private static final Random rnd = new Random();

  public int[] quicksort(int[] arr) {
    return qsHelper(arr, 0, arr.length-1);    
  }

  private static int[] qsHelper(int[] arr, int lo, int hi) {
    if (hi < lo) return arr;
    
    final int pivotI = partition(arr, lo, hi);
    qsHelper(arr, lo, pivotI-1);
    qsHelper(arr, pivotI+1, hi);
    
    return arr;
  }

  private static int partition(int[] arr, int lo, int hi) {
    final int pivotI = rnd.nextInt(hi-lo+1) + lo;
    swap(arr, pivotI, hi);

    int i = lo;
    for (int j = lo; j < hi; j++) {
      if (arr[j] <= arr[hi]) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, hi);

    return i;
  }

  private static void swap(int[] arr, int i, int j) {
    final int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
