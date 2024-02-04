class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();
        final List<List<Integer>> levels = new ArrayList<>();
        final var q = new ArrayDeque<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            var lvlSize = q.size();
            levels.add(new ArrayList<>());
            while (0 < lvlSize--) {
                final var curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                levels.get(levels.size()-1).add(curr.val);
            }
        }
        return levels;
    }
}
