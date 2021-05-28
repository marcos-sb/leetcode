class Solution {
    public int deepestLeavesSum(TreeNode root) {
        final var depthsum = new int[2];
        dfs(root, 0, depthsum);
        return depthsum[1];
    }
    
    private static void dfs(TreeNode node, int depth, int[] depthsum) {
        if (node == null) return;
        
        dfs(node.left, depth+1, depthsum);
        
        if (depthsum[0] < depth) {
            depthsum[0] = depth;
            depthsum[1] = node.val;
        } else if (depthsum[0] == depth)
            depthsum[1] += node.val;
        
        dfs(node.right, depth+1, depthsum);
    }
}
