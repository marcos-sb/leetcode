class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        
        return _isSubtree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private static boolean _isSubtree(TreeNode root, TreeNode node) {
        if (root == null && node == null) return true;
        if (root == null || node == null) return false;
        
        return root.val == node.val && _isSubtree(root.left, node.left) && _isSubtree(root.right, node.right);
    }
}
