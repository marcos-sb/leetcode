class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        final var res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }
    
    private static void postorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}
