class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        var back = head;
        var fw = head;
        while (n-- > 0 && fw != null) {
            fw = fw.next;
        }
        
        if (n > 0) return null;
        
        var prevBack = back;
        while (fw != null) {
            fw = fw.next;
            prevBack = back;
            back = back.next;
        }
        prevBack.next = back.next;
        
        if (back == head) return back.next;
        return head;
    }
}
