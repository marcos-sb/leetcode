class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> levels = new ArrayList<>();
        dfs(root, 0, levels);
        return levels;
    }

    private static void dfs(TreeNode node, int depth, List<List<Integer>> levels) {
        if (node == null) return;
        if (levels.size() == depth) levels.add(new ArrayList<>());
        levels.get(depth).add(node.val);
        dfs(node.left, depth+1, levels);
        dfs(node.right, depth+1, levels);
    }
}
