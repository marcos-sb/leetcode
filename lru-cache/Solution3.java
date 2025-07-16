class LRUCache {
    private final Map<Integer, Node> cache;
    private final int capacity;
    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity+1);
        this.capacity = capacity;
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        final var node = cache.get(key);
        if (node == null) {
            return -1;
        }
        sendToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        final var existingNode = cache.get(key);
        if (existingNode != null) {
            existingNode.val = value;
            sendToFront(existingNode);
        } else {
            if (capacity <= cache.size()) {
                removeLatest();
            }

            final var newNode = new Node(key, value);
            cache.put(key, newNode);
            putAtFront(newNode);
        }
    }

    private void removeLatest() {
        final var latest = dummyTail.prev;
        latest.prev.next = latest.next;
        dummyTail.prev = latest.prev;
        cache.remove(latest.key);
    }

    private void sendToFront(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        putAtFront(node);
    }

    private void putAtFront(Node node) {
        node.prev = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }

    private static class Node {
        Node prev;
        Node next;
        int key;
        int val;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
