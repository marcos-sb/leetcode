class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        final var preOrder = new ArrayList<TreeNode>();
        preOrder(root, preOrder);
        
        final var N = preOrder.size();
        var prev = preOrder.get(0);
        for (var i = 1; i < N; i++) {
            final var curr = preOrder.get(i);
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }
    }

    private static void preOrder(TreeNode node, List<TreeNode> preOrder) {
        if (node == null) return;
        preOrder.add(node);
        preOrder(node.left, preOrder);
        preOrder(node.right, preOrder);
    }
}
