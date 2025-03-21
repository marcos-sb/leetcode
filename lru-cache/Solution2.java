class LRUCache {
    private final Map<Integer, Node> cache;
    private Node dummyHead;
    private Node dummyTail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.dummyHead = new Node(-1, -1);
        this.dummyTail = new Node(-1, -1);
        this.capacity = capacity;

        dummyHead.prev = dummyTail;
        dummyTail.next = dummyHead;
    }

    public int get(int key) {
        final var node = cache.get(key);
        if (node == null) return -1;
        sendToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            final var node = new Node(key, value);
            cache.put(key, node);
            putAtFront(node);
            if (capacity < cache.size()) {
                removeLast();
            }
        } else {
            final var node = cache.get(key);
            node.value = value;
            sendToFront(node);
        }
    }

    private void putAtFront(Node node) {
        node.next = dummyHead;
        node.prev = dummyHead.prev;
        dummyHead.prev.next = node;
        dummyHead.prev = node;
    }

    private void sendToFront(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        putAtFront(node);
    }

    private void removeLast() {
        final var toRemove = dummyTail.next;
        dummyTail.next = toRemove.next;
        toRemove.next.prev = dummyTail;
        cache.remove(toRemove.key);
    }

    private static class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
