class Solution {
    public Node copyRandomList(Node head) {
        return crl(head, new HashMap<>());
    }
    
    private static Node crl(Node node, Map<Node, Node> old2new) {
        if (node == null) return null;
        
        final var newNode = new Node(node.val);
        old2new.put(node, newNode);
        
        newNode.next = crl(node.next, old2new);
        newNode.random = old2new.get(node.random);
        
        return newNode;
    }
}
