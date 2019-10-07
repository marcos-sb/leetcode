package n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    public List<Integer> postorder(Node root) {
        final List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        final Deque<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while(!stack.isEmpty()) {
            final Node top = stack.peekLast();
            if (top.children == null || top.children.isEmpty()) {
                stack.removeLast();
                res.add(top.val);
                continue;
            }
            for (int i = top.children.size()-1; i >= 0; i--) {
                stack.addLast(top.children.get(i));
            }
            top.children = null;
        }
        return res;
    }
}