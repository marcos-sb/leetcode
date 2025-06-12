class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();

        final List<List<Integer>> res = new ArrayList<>();
        var leftRight = true;
        final var q = new ArrayDeque<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            var levelSize = q.size();
            final var lvl = new LinkedList<Integer>();
            while (0 < levelSize--) {
                final var curr = q.poll();
                if (leftRight) {
                    lvl.offerLast(curr.val);
                } else {
                    lvl.offerFirst(curr.val);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            res.add(lvl);
            leftRight = !leftRight;
        }

        return res;
    }
}
