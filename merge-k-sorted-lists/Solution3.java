class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        final var M = lists.length;
        if (M == 0) return null;
        
        final var minHeap = new PriorityQueue<ListNode>(
            (h1,h2) -> Integer.compare(h1.val, h2.val));
        for (var h : lists) if (h != null) minHeap.offer(h);
        
        final var dummyHead = new ListNode(0);
        var last = dummyHead;
        while (!minHeap.isEmpty()) {
            final var curr = minHeap.poll();
            if (curr.next != null) minHeap.offer(curr.next);
            last.next = curr;
            last = last.next;
        }
        
        return dummyHead.next;
    }
}
