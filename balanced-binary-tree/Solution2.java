class Solution {
    public boolean isBalanced(TreeNode root) {
        return 0 <= heightBalance(root);
    }

    private static int heightBalance(TreeNode root) {
        if (root == null) return 0;
        final var leftBalance = heightBalance(root.left);
        if (leftBalance < 0) return -1;
        final var rightBalance = heightBalance(root.right);
        if (rightBalance < 0) return -1;
        final var rootBalance = Math.abs(leftBalance - rightBalance);
        if (rootBalance > 1) return -1;
        return Math.max(leftBalance, rightBalance) + 1;
    }
}
