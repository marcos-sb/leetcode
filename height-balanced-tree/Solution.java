class Solution {
  public boolean isBalanced(TreeNode root) {
    final Map<TreeNode, Integer> cache = new HashMap<>();
    return Math.abs(height(root.left, cache) - height(root.right, cache)) <= 1;
  }

  private static int height(TreeNode node, Map<TreeNode, Integer> cache) {
    if (node == null) return 0;
    if (cache.containsKey(node)) return cache.get(node);
    final int leftH = height(node.left, cache);
    final int rightH = height(node.right, cache);
    final int height = 1 + Math.max(leftH, rightH);
    cache.put(node, height);
    return height;
  }
}
