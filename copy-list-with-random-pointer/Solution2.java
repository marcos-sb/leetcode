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
        final var dummyHead = new Node(-1);
        dummyHead.next = head;
        var curr = dummyHead;

        while (head != null) {
            final var val = head.val;
            final var newNode = old2new.computeIfAbsent(head, k -> new Node(val));
            if (head.random != null) {
                final var random = head.random;
                newNode.random = old2new.computeIfAbsent(random, k -> new Node(random.val));
            }
            curr.next = newNode;
            curr = curr.next;
            head = head.next;
        }

        return dummyHead.next;
    }
}
