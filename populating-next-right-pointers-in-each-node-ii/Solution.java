class Solution {
    public Node connect(Node node) {
        if (node == null) return null;
        if (node.left != null)
            node.left.next =
                node.right != null ? node.right : leftMost(node.next);
        if (node.right != null) node.right.next = leftMost(node.next);

        connect(node.right);
        connect(node.left);

        return node;
    }

    private static Node leftMost(Node node) {
        if (node == null) return null;
        if (node.left != null || node.right != null)
            return node.left != null ? node.left : node.right;
        return leftMost(node.next);
    }
}
