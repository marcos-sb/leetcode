/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        final var old2new = new HashMap<Node, Node>();

        for (var curr = head; curr != null; curr = curr.next) {
            old2new.put(curr, new Node(curr.val));
        }

        for (var curr = head; curr != null; curr = curr.next) {
            old2new.get(curr).next = old2new.get(curr.next);
            old2new.get(curr).random = old2new.get(curr.random);
        }

        return old2new.get(head);
    }
}
