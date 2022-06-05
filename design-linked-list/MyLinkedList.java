class MyLinkedList {
    private static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }
    
    private Node dummyHead, tail;
    private int length;
    
    public MyLinkedList() {
        dummyHead = new Node(0);
        tail = dummyHead;
        length = 0;
    }
    
    public int get(int index) {
        if (length <= index) return -1;
        var curr = dummyHead;
        while (0 <= index--) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) {
        final Node newNode = new Node(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        if (tail == dummyHead) tail = newNode;
        length++;
    }
    
    public void addAtTail(int val) {
        final Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (length < index) return;
        if (length == index) addAtTail(val);
        
        var curr = dummyHead;
        while (0 < index--) curr = curr.next;
        final var newNode = new Node(val);
        newNode.next = curr.next;
        curr.next = newNode;
        length++;
    }
    
    public void deleteAtIndex(int index) {
        if (length <= index) return;
        var prev = dummyHead;
        while (0 < index--) prev = prev.next;
        if (prev.next == tail) tail = prev;
        prev.next = prev.next.next;
        length--;
    }

    public static void main(String... args) {
        final var l = new MyLinkedList();
        l.addAtHead(7);
        l.addAtHead(2);
        l.addAtHead(1);
        l.addAtIndex(3, 0);
        l.deleteAtIndex(2);
        l.addAtHead(6);
        l.addAtTail(4);
        System.out.println(l.get(4));
        l.addAtHead(4);
        l.addAtIndex(5, 0);
        l.addAtHead(6);
    }
}

/*
 * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
 */