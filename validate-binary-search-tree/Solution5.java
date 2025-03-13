class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private static boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) || (max != null && max <= root.val)) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}
