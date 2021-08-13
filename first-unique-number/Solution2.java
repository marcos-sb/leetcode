class FirstUnique {

    private final Map<Integer, Integer> freq;
    private final Queue<Integer> q;
    
    public FirstUnique(int[] nums) {
        freq = new HashMap<>(nums.length);
        q = new LinkedList<>();
        
        for (var n : nums) freq.put(n, freq.getOrDefault(n,0)+1);
        for (var n : nums) {
            final var nf = freq.get(n);
            if (nf < 2) q.offer(n);
        }
    }
    
    public int showFirstUnique() {
        if (q.isEmpty()) return -1;
        return q.peek();
    }
    
    public void add(int value) {
        final var vf = freq.getOrDefault(value, 0);
        if (vf == 0) q.offer(value);
        if (vf <= 1) freq.put(value, vf+1);
        pollHeadWhileNotUnique();
    }
    
    private void pollHeadWhileNotUnique() {
        while (!q.isEmpty() && freq.get(q.peek()) > 1)
            q.poll();
    }
}
