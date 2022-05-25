class MyHashMap {
    static class Pair {
        int k, v;
        Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }
    static class Node {
        Pair p;
        Node prev, next;
        Node(Pair p, Node prev, Node next) {
            this.p = p;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node find(Node root, int key) {
        if (root == null) return null;
        if (root.p != null && root.p.k == key) return root;
        return find(root.prev, key);
    }
    
    private void remove(Node node) {
        if (node == null) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void prepend(Node node, Pair p) {
        if (node == null) return;
        final var newNode = new Node(p, null, null);
        node.prev.next = newNode;
        newNode.prev = node.prev;
        newNode.next = node;
        node.prev = newNode;
    }
    
    private void init(int i) {
        final var dummyLeft = new Node(null, null, null);
        final var dummyRight = new Node(null, null, null);
        dummyLeft.next = dummyRight;
        dummyRight.prev = dummyLeft;
        values[i] = dummyRight;
    }
    
    private static final int DEFAULT_SIZE = 10_000;
    private Node[] values;
    
    public MyHashMap() {
        values = new Node[DEFAULT_SIZE];
    }
    
    public void put(int key, int value) {
        final var bucket = key % values.length;
        if (values[bucket] == null) init(bucket);
        final var existing = find(values[bucket], key);
        if (existing == null) prepend(values[bucket], new Pair(key, value));
        else existing.p.v = value;
    }
    
    public int get(int key) {
        final var bucket = key % values.length;
        final var existing = find(values[bucket], key);
        if (existing == null) return -1;
        return existing.p.v;
    }
    
    public void remove(int key) {
        final var bucket = key % values.length;
        remove(find(values[bucket], key));
    }
}
