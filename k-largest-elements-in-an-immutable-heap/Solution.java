class Solution {
  public List<Integer> kLargestInImmutableHeap(int[] immutableHeap, int k) {
    final var idx2val = new HashMap<Integer, Integer>();
    final Comparator<Integer> cmp = (i,j) -> Integer.compare(idx2val.get(j), idx2val.get(i));
    final var pq = new PriorityQueue<Integer>(cmp);
    
    idx2val.put(0, immutableHeap[0]);
    pq.offer(0);
    final var res = new ArrayList<Integer>(k);
    for (var i = 0; i < k && !pq.isEmpty(); i++) {
      final var currIdx = pq.poll();
      res.add(idx2val.get(currIdx));

      final var left = 2*currIdx + 1;
      if (left >= immutableHeap.length) break;
      idx2val.put(left, immutableHeap[left]);
      pq.offer(left);

      final var right = 2*currIdx + 2;
      if (right >= immutableHeap.length) break;
      idx2val.put(right, immutableHeap[right]);
      pq.offer(right);
    }

    return res;
  }
}
