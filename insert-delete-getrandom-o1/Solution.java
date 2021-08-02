class RandomizedSet {
    private final Map<Integer, Integer> el2idx;
    private final List<Integer> els;
    
    public RandomizedSet() {
        el2idx = new HashMap<>();
        els = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (el2idx.containsKey(val)) return false;
        el2idx.put(val, els.size());
        return els.add(val);
    }
    
    public boolean remove(int val) {
        if (!el2idx.containsKey(val)) return false;
        final int idx = el2idx.get(val);
        final int last = els.get(els.size()-1);
        els.set(idx, last);
        els.remove(els.size()-1);
        el2idx.put(last, idx);
        el2idx.remove(val);
        return true;
    }
    
    public int getRandom() {
        final var rnd = ThreadLocalRandom.current();
        final var idx = rnd.nextInt(0, els.size());
        return els.get(idx);
    }
}
