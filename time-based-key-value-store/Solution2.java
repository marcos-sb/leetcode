class TimeMap {
    private final Map<String, TreeSet<Pair<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(
            key,
            (k) -> new TreeSet<>((p1, p2) -> Integer.compare(p1.getKey(), p2.getKey()))
        ).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) return "";
        final var floor = store.get(key).floor(new Pair<>(timestamp, null));
        return floor != null ? floor.getValue() : "";
    }
}
