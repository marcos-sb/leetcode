class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode headLeft = null;
        ListNode lastLeft = null;
        ListNode headRight = null;
        ListNode lastRight = null;
        
        while (head != null) {
            if (head.val < x) {
                if (headLeft == null) {
                    headLeft = head;
                    lastLeft = head;
                } else {
                    lastLeft.next = head;
                    lastLeft = head;
                }
            } else {
                if (headRight == null) {
                    headRight = head;
                    lastRight = head;
                } else {
                    lastRight.next = head;
                    lastRight = head;
                }
            }
            head = head.next;
        }
        
        if (headLeft == null) return headRight;
        if (headLeft != null) lastLeft.next = headRight;
        if (headRight != null) lastRight.next = null;
        
        return headLeft;
    }
}
