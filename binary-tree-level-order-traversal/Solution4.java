class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        
        final List<List<Integer>> res = new ArrayList<>();
        final var q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            var lvlLen = q.size();
            final var level = new ArrayList<Integer>();
            while (0 < lvlLen--) {
                final var cur = q.poll();
                level.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(level);
        }

        return res;
    }
}
