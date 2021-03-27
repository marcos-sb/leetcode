class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;
        if (depth == 1) {
            final var newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        if (depth == 2) {
            final var newLeft = new TreeNode(val);
            newLeft.left = root.left;
            root.left = newLeft;
            final var newRight = new TreeNode(val);
            newRight.right = root.right;
            root.right = newRight;
        }
        
        addOneRow(root.left, val, depth-1);
        addOneRow(root.right, val, depth-1);
        
        return root;
    }
}
