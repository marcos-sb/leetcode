class Solution {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final var left = Math.max(dfs(root.left), 0);
        final var right = Math.max(dfs(root.right), 0);

        final var newSum = root.val + left + right;
        maxSum = Math.max(maxSum, newSum);

        return root.val + Math.max(left, right);
    }
}
