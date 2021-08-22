import java.util.NavigableMap;

class TimeMap {
    private final Map<String, NavigableMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>())
           .put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        final var timeMap = map.get(key);
        final var timeEntry = timeMap.floorEntry(timestamp);
        if (timeEntry == null) return "";
        return timeEntry.getValue();
    }
}
