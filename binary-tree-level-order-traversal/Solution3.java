class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        
        final List<List<Integer>> ret = new ArrayList<>();
        final var q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            final var lvl = new ArrayList<Integer>();
            var size = q.size();
            while (size-- > 0) {
                final var cur = q.poll();
                lvl.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            ret.add(lvl);
        }
        
        return ret;
    }
}
