class Solution2 {
    public Node lowestCommonAncestor(Node p, Node q) {
        final var pDepth = depth(p);
        final var qDepth = depth(q);
        var deepest = pDepth > qDepth ? p : q;
        var shallowest = deepest == p ? q : p;
        var diffDepth = Math.abs(pDepth - qDepth);
        
        while (diffDepth-- > 0) deepest = deepest.parent;
        while (deepest != shallowest) {
            deepest = deepest.parent;
            shallowest = shallowest.parent;
        }
        
        return deepest;
    }
    
    private static int depth(Node node) {
        var depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
