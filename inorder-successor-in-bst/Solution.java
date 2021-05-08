public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return ios(null, root, p);
    }

    private static TreeNode ios(TreeNode parent, TreeNode node, TreeNode p) {
        if (node == null) return null;
        if (node == p) {
            if (node.right == null) return parent;
            return leftMost(node.right);
        }

        final TreeNode left = ios(node, node.left, p);
        if (left != null) return left;
        return ios(parent, node.right, p);
    }

    private static TreeNode leftMost(TreeNode node) {
        if (node.left == null) return node;
        return leftMost(node.left);
    }
}
