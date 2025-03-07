class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final var dummyHead = new ListNode();
        var dummyTail = dummyHead;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                dummyTail.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                dummyTail.next = list1;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                dummyTail.next = list1;
                list1 = list1.next;
            } else {
                dummyTail.next = list2;
                list2 = list2.next;
            }
            dummyTail = dummyTail.next;
        }
        return dummyHead.next;
    }
}
