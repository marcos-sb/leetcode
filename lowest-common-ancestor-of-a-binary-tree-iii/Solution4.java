class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        final var depthP = depth(p);
        final var depthQ = depth(q);
        var lowestDepth = depthP < depthQ ? p : q;
        var highestDepth = lowestDepth == p ? q : p;
        var diff = Math.abs(depthP - depthQ);

        while (0 < diff--) {
            highestDepth = highestDepth.parent;
        }

        while (lowestDepth != highestDepth) {
            lowestDepth = lowestDepth.parent;
            highestDepth = highestDepth.parent;
        }

        return lowestDepth;
    }

    private static int depth(Node node) {
        var depth = 0;
        while (node != null) {
            node = node.parent;
            ++depth;
        }
        return depth;
    }
}
