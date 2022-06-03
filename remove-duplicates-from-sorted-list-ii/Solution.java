class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        final var freqs = new HashMap<Integer, Integer>();
        var curr = head;
        while (curr != null) {
            freqs.put(curr.val, freqs.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        
        final var res = new ListNode();
        var tail = res;
        var prev = head;
        curr = head;
        while (curr != null) {
            if (freqs.get(curr.val) == 1) {
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
