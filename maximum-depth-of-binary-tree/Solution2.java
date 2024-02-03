class Solution {
    public int maxDepth(TreeNode root) {
        final var res = new int[]{0};
        dfs(root, 1, res);
        return res[0];
    }

    public static void dfs(TreeNode node, int depth, int[] maxDepth) {
        if (node == null) return;
        maxDepth[0] = Math.max(maxDepth[0], depth);
        dfs(node.left, depth+1, maxDepth);
        dfs(node.right, depth+1, maxDepth);
    }
}
