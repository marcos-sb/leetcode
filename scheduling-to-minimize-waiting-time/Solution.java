class Solution {
  public List<Integer> minimizeWaitTime(int[] tasks) {
    final Comparator<Integer> cmp = (i,j) -> {
      final int cmpDuration = Integer.compare(tasks[i], tasks[j]);
      if (cmpDuration != 0) return cmpDuration;
      return Integer.compare(i,j);
    };
    final PriorityQueue<Integer> pq = new PriorityQueue<>(cmp);
    for (int i = 0; i < tasks.length; i++)
      pq.offer(i);
    
    final List<Integer> res = new ArrayList<>();
    while (!pq.isEmpty()) {
      res.add(pq.poll()+1);
    }

    return res;
  }
}
