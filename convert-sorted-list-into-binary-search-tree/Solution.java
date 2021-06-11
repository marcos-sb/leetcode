class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return rec(head);
    }
    
    private static TreeNode rec(ListNode node) {
        if (node == null) return null;
        if (node.next == null)
            return new TreeNode(node.val);
        
        final var mid = findMid(node);
        final var treeNode = new TreeNode(mid.val);
        
        treeNode.left = rec(node);
        treeNode.right = rec(mid.next);
        
        return treeNode;
    }
    
    private static ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;
        var prev = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            prev = head;
            head = head.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return head;
    }
}
