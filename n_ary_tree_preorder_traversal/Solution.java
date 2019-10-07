package n_ary_tree_preorder_traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
    public List<Integer> preorder(Node root) {
        final List<Integer> res = new ArrayList<>(20);
        if (root == null) return res;
        final Deque<Node> stack = new ArrayDeque<>(20);
        stack.addLast(root);
        while(!stack.isEmpty()) {
            final Node top = stack.pollLast();
            res.add(top.val);
            for (int i = top.children.size()-1; i >= 0; i--) {
                stack.addLast(top.children.get(i));
            }
        }
        return res;
    }
}