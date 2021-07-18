class Solution {
    public Node connect(Node root) {
        return dfs(root, null);
    }
    
    private static Node dfs(Node node, Node next) {
        if (node == null) return null;
        node.next = next;
        final Node newNext = dfs(node.right, next == null ? null : next.left);
        dfs(node.left, newNext);
        return node;
    }
}
