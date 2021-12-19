class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        final var dummy = new ListNode();
        merge(list1, list2, dummy);
        return dummy.next;
    }
    
    private static void merge(ListNode l1, ListNode l2, ListNode ret) {
        if (l1 == null) ret.next = l2;
        else if (l2 == null) ret.next = l1;
        else if (l1.val <= l2.val) {
            ret.next = l1;
            merge(l1.next, l2, ret.next);
        } else {
            ret.next = l2;
            merge(l1, l2.next, ret.next);
        }
    }
}
