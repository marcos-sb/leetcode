/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        final var n = lists.length;
        final var minHeap = new PriorityQueue<ListNode>(
            (a,b) -> a.val - b.val
        );

        for (var head : lists)
            if (head != null)
                minHeap.offer(head);

        ListNode head = null;
        var dummyTail = new ListNode(-1);
        while (!minHeap.isEmpty()) {
            dummyTail.next = minHeap.poll();
            dummyTail = dummyTail.next;
            if (head == null)
                head = dummyTail;
            if (dummyTail.next != null)
                minHeap.offer(dummyTail.next);
        }

        return head;
    }
}
