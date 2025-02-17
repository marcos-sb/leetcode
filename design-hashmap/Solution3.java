class MyHashMap {

    private static final int DEFAULT_CAPACITY = 10000;

    private static class Entry {

        private final int a;
        private int b;

        Entry(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private final List<Entry>[] values;

    public MyHashMap() {
        values = new ArrayList[DEFAULT_CAPACITY];
    }

    public void put(int key, int value) {
        final var existingEntry = getEntry(key);
        if (existingEntry.isEmpty()) {
            if (values[key % values.length] == null) {
                values[key % values.length] = new ArrayList<>();
            }
            final var bucket = values[key % values.length];
            bucket.add(new Entry(key, value));
        } else {
            existingEntry.get().b = value;
        }
    }

    public int get(int key) {
        final var existingEntry = getEntry(key);
        return existingEntry.map(entry -> entry.b).orElse(-1);
    }

    public void remove(int key) {
        final var bucket = values[key % values.length];
        if (bucket == null) return;
        final var N = bucket.size();
        for (var i = 0; i < N; i++) {
            final var entry = bucket.get(i);
            if (entry.a == key) {
                bucket.set(i, bucket.get(N - 1));
                bucket.set(N - 1, entry);
                bucket.removeLast();
                return;
            }
        }
    }

    private Optional<Entry> getEntry(int key) {
        final var bucket = values[key % values.length];
        if (bucket == null) return Optional.empty();
        for (var entry : bucket) {
            if (entry.a == key) return Optional.of(entry);
        }
        return Optional.empty();
    }
}
