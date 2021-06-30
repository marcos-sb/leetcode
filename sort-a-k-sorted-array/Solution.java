class Solution {
  public int[] sortNearlySortedArray(int[] arr, int k) {
    if (arr == null || arr.length <= 1) return arr;

    final Comparator<Integer> cmp = (i,j) -> Integer.compare(arr[i], arr[j]);
    final PriorityQueue<Integer> pq = new PriorityQueue<>(cmp);
    final int[] res = new int[arr.length];
    int ri = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = -k; j <= k; j++) {
        if (i+j < 0 || i+j >= arr.length) continue;
        pq.offer(i+j);
      }
      final int mini = pq.poll();
      res[ri++] = arr[mini];
      arr[mini] = Integer.MAX_VALUE;
      pq.clear();
    }

    return res;
  }
}
