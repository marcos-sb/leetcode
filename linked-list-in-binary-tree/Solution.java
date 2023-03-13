class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val && (isPath(head.next, root.left) || isPath(head.next, root.right)))
            return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean isPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return isPath(head.next, root.left) || isPath(head.next, root.right);
    }
}
