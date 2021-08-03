class LFUCache {
    static class Node {
        int useCount, key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.useCount = 0;
            prev = null;
            next = null;
        }
        @Override
        public String toString() {
            return String.format("(%d,%d)", key, val);
        }
    }

    static class LinkedList {
        int size;
        Node head, tail;
        LinkedList() {
            size = 0;
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }
        Node addLast(Node ins) {
            tail.prev.next = ins;
            ins.prev = tail.prev;
            ins.next = tail;
            tail.prev = ins;
            size++;
            return ins;
        }
        Node removeFirst() {
            if (size == 0) return null;
            return remove(head.next);
        }
        Node remove(Node node) {
            size--;
            return doRemove(node);
        }
        private Node doRemove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }
    }

    private final Map<Integer, Node> kv;
    private final Map<Integer, LinkedList> use;
    private int minUse;
    private final int capacity;

    public LFUCache(int capacity) {
        this.kv = new HashMap<>(capacity);
        this.use = new HashMap<>(capacity);
        this.minUse = 1;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!kv.containsKey(key)) return -1;

        final var node = kv.get(key);
        final var ll = use.get(node.useCount);
        ll.remove(node);
        if (minUse == node.useCount && ll.size == 0) // node is the last one with minUse
            minUse++;

        node.useCount++;
        use.computeIfAbsent(node.useCount, k -> new LinkedList())
            .addLast(node);

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        final var node = kv.computeIfAbsent(key, k -> new Node(key, value));

        // existing node
        if (node.useCount != 0) {
            node.val = value;
            final var ll = use.get(node.useCount);
            ll.remove(node);
            if (minUse == node.useCount && ll.size == 0) // node is the last one with minUse
                minUse++;
        } else { // non-existing node
            if (kv.size() > capacity) { // at capacity
                final var ll = use.get(minUse);
                final var rem = ll.removeFirst();
                kv.remove(rem.key);
            }
            minUse = 1;
        }

        node.useCount++;
        use.computeIfAbsent(node.useCount, k -> new LinkedList())
            .addLast(node);

        kv.put(key, node);
    }
}


