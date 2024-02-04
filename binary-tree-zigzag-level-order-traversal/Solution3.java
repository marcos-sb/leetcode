class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        final List<List<Integer>> levels = new LinkedList<>();
        final var q = new LinkedList<TreeNode>();
        q.offer(root);
        var leftRight = true;
        while (!q.isEmpty()) {
            var lvlSize = q.size();
            final var level = new LinkedList<Integer>();
            while (0 < lvlSize--) {
                final var curr = q.poll();
                if (leftRight) level.offerLast(curr.val);
                else level.offerFirst(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            levels.add(level);
            leftRight = !leftRight;
        }
        return levels;
    }
}
