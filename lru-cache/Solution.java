class LRUCache {
    static class Node {
        Integer key, val;
        Node prev, next;
        Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
        @Override
        public String toString() {
            return String.format("%d,%d", key, val);
        }
    }
    
    private final Map<Integer, Node> entries;
    private final int cap;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.entries = new HashMap<>(capacity);
        this.cap = capacity;
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!entries.containsKey(key)) return -1;
        
        final Node entry = entries.get(key);
        touch(entry);
        
        return entry.val;
    }
    
    private void touch(Node node) {
        remove(node);
        addLast(node);
    }
    
    private void remove(Node node) {
        final Node prev = node.prev;
        final Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void addLast(Node node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }
    
    public void put(int key, int value) {
        if (entries.containsKey(key)) {
            final Node node = entries.get(key);
            touch(node);
            node.val = value;
            return;
        }

        if (entries.size() >= cap) {
            final Node oldest = head.next;
            entries.remove(oldest.key);
            remove(oldest);
        }
        
        final Node node = new Node(key, value);
        entries.put(key, node);
        addLast(node);
    }
}

