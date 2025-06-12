/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        var rightmostChild = root.right != null ? root.right : root.left;
        if (rightmostChild != null && root.next != null) {
            rightmostChild.next = findLeftmost(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private static Node findLeftmost(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }
}
