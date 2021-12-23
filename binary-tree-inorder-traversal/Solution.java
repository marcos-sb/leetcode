class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        final var ret = new ArrayList<Integer>();
        inorder(root, ret);
        return ret;
    }
    
    private static void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
