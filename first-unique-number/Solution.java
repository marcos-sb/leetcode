class FirstUnique {

    private final Map<Integer, Integer> freq;
    private final Queue<Integer> q;
    
    public FirstUnique(int[] nums) {
        freq = new HashMap<>(nums.length);
        q = new LinkedList<>();
        for (var n : nums) this.add(n);
    }
    
    public int showFirstUnique() {
        while (!q.isEmpty()) {
            final var head = q.peek();
            final var headFreq = freq.getOrDefault(head, 0);
            if (headFreq < 2) return head;
            q.poll();
        }
        return -1;
    }
    
    public void add(int value) {
        q.offer(value);
        freq.put(value, freq.getOrDefault(value,0)+1);
    }
}
