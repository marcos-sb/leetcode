public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        final Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            final List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                final TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            levels.add(level);
        }

        return levels;
    }
}
