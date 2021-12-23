class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        final var ret = new ArrayList<Integer>();
        preorder(root, ret);
        return ret;
    }
    
    private static void preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}
