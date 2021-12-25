class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        final var newLeft = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = newLeft;
        
        return root;
    }
}
