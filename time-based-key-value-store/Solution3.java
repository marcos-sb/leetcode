import java.util.NavigableMap;

class TimeMap {
    private final Map<String, NavigableMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, (k) -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        final var floor = store.get(key).floorEntry(timestamp);
        return floor != null ? floor.getValue() : "";
    }
}
