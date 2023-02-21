class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        aux(root);
        return max;
    }

    private int aux(TreeNode root) {
        if (root == null) return -1;
        final var left = 1 + aux(root.left);
        final var right = 1 + aux(root.right);
        max = Math.max(max, left+right);
        return Math.max(left, right);
    }
}
