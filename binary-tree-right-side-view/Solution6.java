class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        final var res = new ArrayList<Integer>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (res.size() <= level) res.add(root.val);
        dfs(root.right, level+1, res);
        dfs(root.left, level+1, res);
    }
}
