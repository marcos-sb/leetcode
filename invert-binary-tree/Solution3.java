class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        final var tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
