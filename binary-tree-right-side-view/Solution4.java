class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        final var q = new ArrayDeque<TreeNode>();
        q.offer(root);
        final var res = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            var lastNode = q.peek();
            var lvlSize = q.size();
            while (0 < lvlSize--) {    
                final var curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                lastNode = curr;
            }
            res.add(lastNode.val);
        }
        return res;
    }
}
