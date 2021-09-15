class Solution {
    private Node head = null;
    private Node tail = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        aux(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
    
    private void aux(Node root) {
        if (root == null) return;
        
        aux(root.left);
        if (tail == null) head = root;
        else {
            tail.right = root;
            root.left = tail;
        }
        tail = root;
        
        aux(root.right);
    }
}
