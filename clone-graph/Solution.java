class Solution {
    private final Node[] cloned;

    public Solution() {
        cloned = new Node[101];
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (cloned[node.val] != null)
            return cloned[node.val];

        final var clone = new Node(node.val);
        cloned[node.val] = clone;
        for (var n : node.neighbors)
            clone.neighbors.add(cloneGraph(n));

        return clone;
    }
}
