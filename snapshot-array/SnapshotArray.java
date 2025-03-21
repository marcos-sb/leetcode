class SnapshotArray {
    private final NavigableMap<Integer, Integer>[] array;
    private int snapId;

    public SnapshotArray(int length) {
        array = new TreeMap[length];
        snapId = 0;
    }

    public void set(int index, int val) {
        if (array[index] == null)
            array[index] = new TreeMap<>();
        array[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        final var snapshotMap = array[index];
        if (snapshotMap == null) return 0;
        final var entry = snapshotMap.floorEntry(snapId);
        if (entry == null) return 0;
        return entry.getValue();
    }
}
