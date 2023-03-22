class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return List.of();

        final List<List<Integer>> res = new ArrayList<>();
        final var q = new LinkedList<Node>();
        
        q.offer(root);
        while (!q.isEmpty()) {
            var size = q.size();
            final var lvl = new ArrayList<Integer>();
            while (0 < size--) {
                final var cur = q.poll();
                lvl.add(cur.val);
                for (var c : cur.children) q.offer(c);
            }
            res.add(lvl);
        }

        return res;
    }
}
