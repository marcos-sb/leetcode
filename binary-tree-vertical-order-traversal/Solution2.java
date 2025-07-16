class Solution {
    private final Map<Integer, List<Integer>> order;
    private int minOrder;
    private int maxOrder;

    public Solution() {
        this.order = new HashMap<>();
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return List.of();

        final var q = new ArrayDeque<NodeOrder>();
        q.offer(new NodeOrder(root, 0));
        while (!q.isEmpty()) {
            final var curr = q.poll();
            final var node = curr.node;
            final var order = curr.order;

            minOrder = Math.min(minOrder, order);
            maxOrder = Math.max(maxOrder, order);

            this.order.computeIfAbsent(order, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) {
                q.offer(new NodeOrder(node.left, order-1));
            }
            if (node.right != null) {
                q.offer(new NodeOrder(node.right, order+1));
            }
        }

        final List<List<Integer>> res = new ArrayList<>(maxOrder-minOrder+1);
        for (var i = minOrder; i <= maxOrder; ++i) {
            res.add(order.get(i));
        }

        return res;
    }

    private static record NodeOrder(TreeNode node, int order) {}
}
