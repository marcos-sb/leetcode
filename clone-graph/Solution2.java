class Solution {
    private static final Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        final var clone = new Node(node.val);
        visited.put(node, clone);
        for (var v : node.neighbors) {
            clone.neighbors.add(cloneGraph(v));
        }
        return clone;
    }

}
