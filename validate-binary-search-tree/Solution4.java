class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private static boolean dfs(TreeNode root, Integer left, Integer right) {
        if (root == null) return true;
        if ((left != null && root.val <= left) || (right != null && right <= root.val))
            return false;
        return dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }
}
