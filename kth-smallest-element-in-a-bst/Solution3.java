class Solution {
    public int kthSmallest(TreeNode root, int k) {
        final var res = new int[]{k, -1};
        dfs(root, res);
        return res[1];
    }

    private static void dfs(TreeNode node, int[] kth) {
        if (node == null) return;
        dfs(node.left, kth);
        if (--kth[0] == 0) {
            kth[1] = node.val;
            return;
        }
        dfs(node.right, kth);
    }
}
