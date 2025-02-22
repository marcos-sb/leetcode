class MyLinkedList {
    private static class Node {
        int val;
        Node prev, next;
        Node() {
            this(-1);
        }
        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        final var res = getNode(index);
        return res == null ? -1 : res.val;
    }

    public void addAtHead(int val) {
        final var node = new Node(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void addAtTail(int val) {
        final var node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || size < index) return;
        if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            final var curr = getNode(index);
            if (curr == null) return;
            final var node = new Node(val);
            node.prev = curr.prev;
            node.next = curr;
            curr.prev.next = node;
            curr.prev = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || size <= index) return;
        final var curr = getNode(index);
        if (curr == null) return;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || size <= index) return null;
        Node curr = null;
        if (index < size / 2) {
            curr = head.next;
            while (0 < index--) {
                curr = curr.next;
            }
        } else {
            curr = tail.prev;
            while (index++ < size-1) {
                curr = curr.prev;
            }
        }
        return curr;
    }
}
