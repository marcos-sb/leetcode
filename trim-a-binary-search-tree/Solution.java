class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        if (low <= root.val && root.val <= high) {
            return root;
        } else {
            if (root.left != null) return root.left;
            else return root.right;
        }
    }
}
