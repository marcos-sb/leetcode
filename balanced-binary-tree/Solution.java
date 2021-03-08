class Solution {
    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }
    private int height(TreeNode node) {
        if (!balanced) return 0;
        if (node == null) return 0;
        final int l = height(node.left);
        final int r = height(node.right);
        if (Math.abs(l-r) > 1) balanced = false;
        return Math.max(l, r) + 1;
    }
}
