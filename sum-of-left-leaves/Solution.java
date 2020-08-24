class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    private static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
