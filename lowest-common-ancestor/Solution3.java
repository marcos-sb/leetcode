class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        final var left = lowestCommonAncestor(root.left, p, q);
        final var right = lowestCommonAncestor(root.right, p, q);
        if (root == p || root == q) return root;
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
