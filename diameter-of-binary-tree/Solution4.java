class Solution {
    private int maxPathLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxPathLen;
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        final var left = height(root.left);
        final var right = height(root.right);
        maxPathLen = Math.max(maxPathLen, left+right);
        return 1 + Math.max(left, right);
    }
}
