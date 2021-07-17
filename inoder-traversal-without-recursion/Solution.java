class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return List.of();

    final List<Integer> res = new ArrayList<>();
    final Set<TreeNode> visited = new HashSet<>();
    final Deque<TreeNode> stack = new LinkedList<>();
    stack.offerLast(root);
    TreeNode curr;
    while (!stack.isEmpty()) {
      curr = stack.pollLast();
      visited.add(curr);
      if (curr.right != null && !visited.contains(curr.right)) {
        stack.offerLast(curr.right);
        visited.add(curr.right);
      }
      if (curr.left != null && !visited.contains(curr.left)) {
        stack.offerLast(curr);
        stack.offerLast(curr.left);
      } else {
        res.add(curr.val);
      }
    }

    return res;
  }
}
