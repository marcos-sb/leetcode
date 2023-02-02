class Solution {
    public ListNode middleNode(ListNode head) {
        var fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }
        return head;
    }
}
