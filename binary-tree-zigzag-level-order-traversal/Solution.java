class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return List.of();
        
        final List<List<Integer>> res = new ArrayList<>();
        final var q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            var size = q.size();
            var level = new ArrayList<Integer>(size);
            while (0 < size--) {
                final var curr = q.pollFirst();
                level.add(curr.val);
                if (curr.left != null) q.offerLast(curr.left);
                if (curr.right != null) q.offerLast(curr.right);
            }
            res.add(level);
            
            if (q.isEmpty()) break;
            
            size = q.size();
            level = new ArrayList<Integer>(size);
            while (0 < size--) {
                final var curr = q.pollLast();
                level.add(curr.val);
                if (curr.right != null) q.offerFirst(curr.right);
                if (curr.left != null) q.offerFirst(curr.left);
            }
            res.add(level);
        }
        
        return res;
    }
}
