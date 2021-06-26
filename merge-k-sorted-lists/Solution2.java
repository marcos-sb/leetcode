public class Solution2 {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null) return null;

    final Comparator<Integer> cmp = (i,j) -> Integer.compare(lists[i].val, lists[j].val);
    final PriorityQueue<Integer> pq = new PriorityQueue<>(cmp);

    for (int i = 0; i < lists.length; i++) pq.offer(i);

    final ListNode dummyHead = new ListNode(-1);
    ListNode last = dummyHead;
    while (!pq.isEmpty()) {
      final int lowest = pq.poll();
      final ListNode lowestHead = lists[lowest];
      if (lowestHead == null) continue;
      last.next = lowestHead;
      lists[lowest] = lowestHead.next;
      last = last.next;
      if (lists[lowest] != null) pq.offer(lowest);
    }

    return dummyHead.next;
  }
}
