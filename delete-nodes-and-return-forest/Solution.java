class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        final var toDelete = new boolean[1001];
        for (var d : to_delete) {
            toDelete[d] = true;
        }
        final var res = new ArrayList<TreeNode>();
        post(root, toDelete, res);
        if (!toDelete[root.val]) res.add(root);
        return res;
    }

    private static TreeNode post(TreeNode root, boolean[] toDelete, List<TreeNode> res) {
        if (root == null) return null;
        root.left = post(root.left, toDelete, res);
        root.right = post(root.right, toDelete, res);
        if (toDelete[root.val]) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        return root;
    }
}
