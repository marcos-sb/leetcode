class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        final var depthP = depth(p, 0);
        final var depthQ = depth(q, 0);
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

    private static int depth(Node node, int currDepth) {
        if (node == null) return currDepth-1;
        return depth(node.parent, currDepth+1);
    }
}
