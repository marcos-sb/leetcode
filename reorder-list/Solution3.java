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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        final var mid = mid(head);
        final var l2 = rev(mid);
        merge(head, l2);
    }
    
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        
        var tmp = l1;
        while (l2.next != null) {
            tmp = l1.next;
            l1.next = l2;
            l1 = tmp;
            
            tmp = l2.next;
            l2.next = l1;
            l2 = tmp;
        }
        
        return l1;
    }
    
    private static ListNode mid(ListNode node) {
        if (node == null || node.next == null) return node;
        
        var slow = node;
        var fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private static ListNode rev(ListNode node) {
        if (node == null || node.next == null) return node;

        var prev = node;
        var next = node;
        node = node.next;
        prev.next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
