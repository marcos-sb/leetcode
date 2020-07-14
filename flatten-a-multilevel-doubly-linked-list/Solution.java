class Solution {
    public Node flatten(Node head) {
        return flatten(head, null);
    }
    private Node flatten(Node head, Node next) {
        if (head == null) return null;
        if (head.child != null) {
            final Node oldNext = head.next;
            head.next = flatten(head.child, oldNext);
            head.next.prev = head;
            head.child = null;
            flatten(oldNext, next);
            return head;
        }
        if (head.next == null) {
            head.next = next;
            if (next != null) next.prev = head;
            return head;
        }
        // head.child == null
        head.next = flatten(head.next, next);
        return head;
    }
}
