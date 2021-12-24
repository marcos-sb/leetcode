class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        final var left = new LinkedList<TreeNode>();
        final var right = new LinkedList<TreeNode>();
        left.offer(root); right.offer(root);
        while (!left.isEmpty() && !right.isEmpty()) {
            final var l = left.poll();
            final var r = right.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;

            left.offer(l.left); left.offer(l.right);
            right.offer(r.right); right.offer(r.left);
        }
        
        return true;
    }
}
