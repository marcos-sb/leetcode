/**
 * @NotThreadSafe
 */
class MyHashSet {
    private static final int DEFAULT_INIT_CAPACITY = 16;
    private static final double DEFAULT_MAX_LOAD_FACTOR = 0.75d;
    
    private SortedSet<Integer>[] values;
    private double maxLoadFactor;
    private int sizeToRefactor;
    private int size;

    /** Initialize your data structure here. */
    public MyHashSet() {
        init(DEFAULT_INIT_CAPACITY);
    }
    
    private void init(int capacity) {
        values = new SortedSet[capacity];
        maxLoadFactor = DEFAULT_MAX_LOAD_FACTOR;
        sizeToRefactor = (int) Math.floor(capacity * maxLoadFactor);
        size = 0;
    }
    
    public void add(int key) {
        if (contains(key)) { // Replace
            values[bucket(key)].add(key);
        } else {
            if (sizeToRefactor <= size + 1) resize();
            final int bucket = bucket(key);
            if (values[bucket] == null) values[bucket] = new TreeSet<>();
            values[bucket].add(key);
            size++;
        }
    }
    
    private void resize() {
        final SortedSet<Integer>[] oldValues = values;
        
        init(oldValues.length * 2);
        
        for (int i = 0; i < oldValues.length; i++) {
            if (oldValues[i] == null) continue;
            for (int key : oldValues[i]) add(key);
        }
    }
    
    public void remove(int key) {
        if (contains(key)) {
            values[bucket(key)].remove(key);
            size--;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        final int bucket = bucket(key);
        if (values[bucket] == null) return false;
        return values[bucket].contains(key);
    }
    
    private int bucket(int key) {
        final int hash = Integer.hashCode(key);
        return Math.abs(hash % values.length); 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
