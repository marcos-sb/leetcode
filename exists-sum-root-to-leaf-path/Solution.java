class Solution {
  public boolean hasPathSum(TreeNode node, int targetSum) {
    if (node == null) return targetSum == 0;

    final var currTargetSum = targetSum - node.val;
    return hasPathSum(node.left, currTargetSum) || hasPathSum(node.right, currTargetSum);
  }
}
