class Solution {
    public ListNode sortList(ListNode head) {
        final var tmp = new ArrayList<Integer>();
        var node = head;
        while (node != null) {
            tmp.add(node.val);
            node = node.next;
        }
        
        Collections.sort(tmp);
        
        node = head;
        for (var n : tmp) {
            node.val = n;
            node = node.next;
        }
        
        return head;
    }
}
