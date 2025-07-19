class Solution {
    private int visited;

    public Solution() {
        this.visited = 0;
    }

    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k).val;
    }

    private TreeNode inOrder(TreeNode node, int k) {
        if (node == null) return null;
        final var left = inOrder(node.left, k);
        if (left != null) return left;
        if (k == ++visited) return node;
        return inOrder(node.right, k);
    }
}
