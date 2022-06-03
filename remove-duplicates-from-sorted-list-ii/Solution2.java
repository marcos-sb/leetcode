class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        final var freqs = new int[201];
        var curr = head;
        while (curr != null) {
            freqs[curr.val+100]++;
            curr = curr.next;
        }
        
        final var res = new ListNode();
        var tail = res;
        var prev = head;
        curr = head;
        while (curr != null) {
            if (freqs[curr.val+100] == 1) {
                tail.next = curr;
                tail = curr;
            }
            prev = curr;
            curr = curr.next;
            prev.next = null;
        }
        
        return res.next;
    }
}
