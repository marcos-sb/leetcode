class MyHashMap {
    private static final int N = 1_000_001;
    private final Integer[] values;
    
    public MyHashMap() {
        values = new Integer[N];
    }
    
    public void put(int key, int value) {
        values[key] = value;
    }
    
    public int get(int key) {
        if (values[key] == null) return -1;
        return values[key];
    }
    
    public void remove(int key) {
        values[key] = null;
    }
}
