package n_ary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.Collections;
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
    }
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return new ArrayList<>();
        final List<Integer> rootList = Collections.singletonList(root.val);
        final List<List<Integer>> levels = new ArrayList<>();
        levels.add(rootList);
        return levelOrder(root, 1, levels);
    }
    private static List<List<Integer>> levelOrder(Node root, int level, List<List<Integer>> levels) {
        if (root == null) return levels;
        if (root.children != null && !root.children.isEmpty()) {
            if (levels.size() == level) {
                levels.add(new ArrayList<>());
            }
            for (Node n : root.children) {
                levelOrder(n, level + 1, levels);
                levels.get(level).add(n.val);
            }
        }
        return levels;
    }
}
