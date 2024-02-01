class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        final var res = new ArrayList<Integer>();
        rsv(root, 0, res);
        return res;
    }

    private static void rsv(TreeNode root, int lvl, List<Integer> res) {
        if (root == null) return;
        if (res.size() == lvl) res.add(root.val);
        rsv(root.right, lvl+1, res);
        rsv(root.left, lvl+1, res);
    }
}
