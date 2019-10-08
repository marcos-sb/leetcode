package maximum_depth_of_n_ary_tree;

import java.util.List;

class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        return maxDepth(root, 0);
    }
    private int maxDepth(Node node, int nodeDepth) {
        if (node == null) return nodeDepth;
        if (node.children == null) return nodeDepth+1;
        int maxDepth = nodeDepth+1;
        for (Node n : node.children) {
            maxDepth = Math.max(maxDepth(n, nodeDepth+1), maxDepth);
        }

        return maxDepth;
    }
}