class Solution2 {
    static class Pair {
        ListNode node;
        int posFromEnd;
        Pair(ListNode node, int posFromEnd) {
            this.node = node;
            this.posFromEnd = posFromEnd;
        }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return dfs(head, n).node;
    }
    
    private static Pair dfs(ListNode head, int n) {
        if (head == null) return new Pair(null, 1);
        
        final var p = dfs(head.next, n);
        if (p.posFromEnd == n) return new Pair(head.next, n+1);
        head.next = p.node;
        return new Pair(head, p.posFromEnd+1);
    }
}
