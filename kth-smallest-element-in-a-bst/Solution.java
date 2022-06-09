class Solution {
    private int kth;
    
    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        return inorder(root);
    }
    
    private final int inorder(TreeNode node) {
        if (node == null) return -1;
        final var rec = inorder(node.left);
        if (rec != -1) return rec;
        if (--kth == 0) return node.val;
        return inorder(node.right);
    }
}
