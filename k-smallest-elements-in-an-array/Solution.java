
class Solution {
  public List<Integer> kSmallestElements(int[] elements, int k) {
    final Comparator<Integer> cmp = (a,b) -> Integer.compare(b,a);
    final var pq = new PriorityQueue<Integer>(cmp);

    for (var el : elements) {
      if (pq.size() < k) pq.offer(el);
      else if (el < pq.peek()) {
        pq.poll();
        pq.offer(el);
      }
    }

    final var res = new ArrayList<Integer>(k);
    while (!pq.isEmpty()) res.add(pq.poll());

    return res;
  }
}
