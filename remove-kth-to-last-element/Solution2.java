class ReverseLinkedList {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        final var dummyHead = new LinkedListNode(-1);
        dummyHead.next = head;
        var l = dummyHead;
        var r = dummyHead;
        while (0 < n-- && r != null) r = r.next;
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;
        return dummyHead.next;
    }
}
