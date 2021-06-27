class Solution {
  public int kthLargest(int[] arr, int k) {
    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int n : arr) {
      if (pq.size() < k) pq.offer(n);
      else if (pq.peek() < n) {
        pq.poll(); pq.offer(n);
      }
    }
    
    return pq.peek();
  }
}
