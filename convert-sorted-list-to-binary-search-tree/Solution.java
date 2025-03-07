class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        final var mid = middleNode(head);
        final var root = new TreeNode(mid.val);
        if (head == mid) return root;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private static ListNode middleNode(ListNode head) {
        ListNode prev = null;
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }
}
