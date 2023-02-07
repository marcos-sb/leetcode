class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) return;
        if (res.size() <= level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        dfs(root.left, level+1, res);
        dfs(root.right, level+1, res);
    }
}
