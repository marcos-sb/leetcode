class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) return searchBST(root.left, val);
        if (root.val < val) return searchBST(root.right, val);
        return root;
    }
}
