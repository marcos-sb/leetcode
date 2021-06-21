class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, int x, int y) {
    if (root == null) return null;
    if (root.val == x || root.val == y) return root;
    
    final var left = lowestCommonAncestor(root.left, x, y);
    final var right = lowestCommonAncestor(root.right, x, y);
    final var leftMatch = left != null;
    final var rightMatch = right != null;
    
    if (leftMatch && rightMatch) return root;
    if (leftMatch) return left;
    if (rightMatch) return right;
    
    return null;
  }
}
