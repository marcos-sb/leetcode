class Solution {
    private int moves;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final var left = dfs(root.left);
        final var right = dfs(root.right);

        moves += Math.abs(left) + Math.abs(right);

        return root.val + left + right - 1;
    }
}
