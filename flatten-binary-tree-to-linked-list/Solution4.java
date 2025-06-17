class Solution {
    TreeNode prev;

    public Solution() {
        this.prev = null;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        final var right = root.right;
        if (prev != null) {
            prev.right = root;
        }

        prev = root;
        flatten(root.left);
        root.left = null;
        flatten(right);
    }
}
