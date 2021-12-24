class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0, 0);
    }
    
    private static int maxDepth(TreeNode node, int depth, int maxDepth) {
        if (node == null) return maxDepth;
        final var nodeDepth = depth+1;
        final var maxSoFar = Math.max(maxDepth, nodeDepth);
        final var maxLeft = maxDepth(node.left, nodeDepth, maxSoFar);
        final var maxRight = maxDepth(node.right, nodeDepth, maxSoFar);
        return Math.max(maxLeft, maxRight);
    }
}
