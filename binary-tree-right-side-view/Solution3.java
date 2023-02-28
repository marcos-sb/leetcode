class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        final var res = new ArrayList<Integer>();
        rightSideView(root, 0, res);
        return res;
    }

    private static void rightSideView(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        if (res.size() == depth) res.add(root.val);
        rightSideView(root.right, depth+1, res);
        rightSideView(root.left, depth+1, res);
    }
}
