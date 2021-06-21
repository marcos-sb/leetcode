class Solution {
  public boolean isValidBST(TreeNode root) {
    return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean dfs(TreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.val < min || max < root.val) return false;
    return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
  }
}
