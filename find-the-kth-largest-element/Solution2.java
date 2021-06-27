class Solution2 {
  public int kthLargest(int[] arr, int k) {
    if (k > arr.length) return -1;
    int l = 0;
    int r = arr.length-1;

    Random rnd = new Random();

    while (l <= r) {
      int pi = rnd.nextInt(r-l+1) + l;
      pi = partition(arr, l, r, pi);

      if (pi == arr.length-k) return arr[pi];
      else if (arr.length-k < pi) r = pi-1;
      else l = pi+1;
    }

    return -1;
  }

  private static int partition(int[] arr, int l, int r, int pi) {
    swap(arr, r, pi);

    for (int i = l; i < r; i++)
      if (arr[i] < arr[r]) {
        swap(arr, i, l);
        l++;
      }
    
    swap(arr, l, r);

    return l;
  }

  private static void swap(int[] arr, int i, int j) {
    final int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
