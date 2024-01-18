class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private static TreeNode flattenTree(TreeNode node) {
        if (node == null) return null;
        if (node.left == null && node.right == null) return node;
        final var leftTail = flattenTree(node.left);
        final var rightTail = flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : leftTail;
    }
}
