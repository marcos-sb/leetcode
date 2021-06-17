class Solution2 {
  public List<List<Integer>> levelOrderTraversal(TreeNode root) {
    if (root == null) return List.of();

    final List<List<Integer>> res = new ArrayList<>();
    final var q = new ArrayDeque<TreeNode>();
    q.offer(root);
    var lvl = 0;
    while (!q.isEmpty()) {
      var sz = q.size();
      final var byLevel = new ArrayList<Integer>();
      res.add(byLevel);
      while (sz-- > 0) {
        final var curr = q.poll();
        byLevel.add(curr.val);
        if (curr.left != null) q.offer(curr.left);
        if (curr.right != null) q.offer(curr.right);
      }
      lvl++;
    }

    return res;
  }
}
