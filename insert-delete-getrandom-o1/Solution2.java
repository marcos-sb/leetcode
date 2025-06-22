class RandomizedSet {

    private final List<Integer> data;
    private final Map<Integer, Integer> dataIndexByElement;

    public RandomizedSet() {
        this.data = new ArrayList<>();
        this.dataIndexByElement = new HashMap<>();
    }

    public boolean insert(int val) {
        if (!dataIndexByElement.containsKey(val)) {
            data.add(val);
            dataIndexByElement.put(val, data.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        final var dataIndex = dataIndexByElement.remove(val);
        if (dataIndex == null) return false;

        final var lastIndex = data.size() - 1;
        if (dataIndex != lastIndex) {
            final var tmp = data.get(lastIndex);
            data.set(lastIndex, val);
            data.set(dataIndex, tmp);
            dataIndexByElement.put(tmp, dataIndex);
        }
        data.remove(lastIndex);

        return true;
    }

    public int getRandom() {
        final var rndIndx = ThreadLocalRandom.current().nextInt(data.size());
        return data.get(rndIndx);
    }
}
