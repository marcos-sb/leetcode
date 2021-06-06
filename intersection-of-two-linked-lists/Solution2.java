public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final int lenA = length(headA);
        final int lenB = length(headB);
        
        final int diff = lenA - lenB;
        ListNode longHead = null;
        ListNode shortHead = null;
        if (diff < 0) {
            longHead = headB;
            shortHead = headA;
        } else {
            longHead = headA;
            shortHead = headB;
        }
        
        int absDiff = Math.abs(diff);
        while (absDiff-- > 0) longHead = longHead.next;
        
        while (longHead != null && shortHead != null) {
            if (longHead == shortHead) return longHead;
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        
        return null;
    }
    
    private static int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
