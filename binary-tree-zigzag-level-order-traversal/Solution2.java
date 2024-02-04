class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        final List<List<Integer>> levels = new ArrayList<>();
        final var q = new ArrayDeque<TreeNode>();
        q.offer(root);
        var leftRight = true;
        while (!q.isEmpty()) {
            var lvlSize = q.size();
            final var level = new ArrayList<Integer>();
            while (0 < lvlSize--) {
                final var curr = leftRight ? q.pollFirst() : q.pollLast();
                if (leftRight) {
                    if (curr.left != null) q.offerLast(curr.left);
                    if (curr.right != null) q.offerLast(curr.right);
                } else {
                    if (curr.right != null) q.offerFirst(curr.right);
                    if (curr.left != null) q.offerFirst(curr.left);
                }
                level.add(curr.val);
            }
            levels.add(level);
            leftRight = !leftRight;
        }
        return levels;
    }
}
