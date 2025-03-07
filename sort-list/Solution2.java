class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        final var middle = middleNode(head);
        if (middle == head) return middle;
        return merge(sortList(head), sortList(middle));
    }

    private static ListNode middleNode(ListNode node) {
        ListNode prev = null;
        var slow = node;
        var fast = node;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        final var dummyHead = new ListNode();
        var dummyTail = dummyHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                dummyTail.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                dummyTail.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                dummyTail.next = l1;
                l1 = l1.next;
            } else {
                dummyTail.next = l2;
                l2 = l2.next;
            }
            dummyTail = dummyTail.next;
        }
        return dummyHead.next;
    }
}
