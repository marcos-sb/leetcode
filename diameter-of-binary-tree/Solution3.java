class Solution {
    private int maxDistance;

    public Solution() {
        maxDistance = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDistance;
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        final var leftHeight = height(node.left) + 1;
        final var rightHeight = height(node.right) + 1;
        maxDistance = Math.max(maxDistance, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight);
    }
}
