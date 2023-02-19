class Solution {
    public ListNode oddEvenList(ListNode head) {
        final var dummyOdd = new ListNode();
        var tailOdd = dummyOdd;
        final var dummyEven = new ListNode();
        var tailEven = dummyEven;
        var count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                tailOdd.next = head;
                tailOdd = tailOdd.next;
            } else {
                tailEven.next = head;
                tailEven = tailEven.next;
            }
            head = head.next;
            count++;
        }
        tailEven.next = null;
        tailOdd.next = dummyEven.next;
        return dummyOdd.next;
    }
}
