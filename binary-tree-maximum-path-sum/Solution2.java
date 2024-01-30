class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        aux(root, 0);
        return max;
    }

    private int aux(TreeNode root, int sum) {
        if (root == null) return 0;

        final var maxSoFar = Math.max(root.val, root.val + sum);
        max = Math.max(max, maxSoFar);
        final var left = aux(root.left, maxSoFar);
        final var leftMax = Math.max(root.val, root.val + left);
        final var toRight = Math.max(maxSoFar, leftMax);
        final var right = aux(root.right, toRight);
        final var rightMax = Math.max(root.val, root.val + right);
        return Math.max(leftMax, rightMax);
    }
}
