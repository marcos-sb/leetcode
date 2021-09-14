class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == q) return p;
        
        final var inPath = new HashSet<Node>();
        var cur = p;
        while (cur != null) {
            inPath.add(cur);
            cur = cur.parent;
        }
        cur = q;
        while (cur != null && !inPath.contains(cur)) {
            cur = cur.parent;
        }
        
        return cur;
    }
}
