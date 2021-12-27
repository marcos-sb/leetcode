class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBST(TreeNode node, long left, long right) {
        if (node == null) return true;
        if (node.val <= left || right <= node.val) return false;
        return isValidBST(node.left, left, node.val) && isValidBST(node.right, node.val, right);
    }
}
