class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        final var min = Math.min(p.val, q.val);
        final var max = Math.max(p.val, q.val);
        if (min <= root.val && root.val <= max) return root;
        if (min < root.val) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
