class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        final var left = lowestCommonAncestor(root.left, p, q);
        final var right = lowestCommonAncestor(root.right, p, q);
        if ((left == p || left == q) && (right == p || right == q))
            return root;
        if (left == null) return right;
        return left;
    }
}
