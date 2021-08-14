class FirstUnique {
    private final Map<Integer, Boolean> isUnique;
    private final Set<Integer> setQ;
    
    public FirstUnique(int[] nums) {
        isUnique = new HashMap<>(nums.length);
        setQ = new LinkedHashSet<>();
        
        for (var n : nums) add(n);
    }
    
    public int showFirstUnique() {
        if (!setQ.isEmpty())
            return setQ.iterator().next();
        return -1;
    }
    
    public void add(int value) {
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            setQ.add(value);
        } else if (isUnique.get(value)) {
            isUnique.put(value, false);
            setQ.remove(value);
        }
    }
}
