class FreqStack {
    private int maxFreq;
    private final Map<Integer, Deque<Integer>> freq2stack;
    private final Map<Integer, Integer> freqs;
    
    public FreqStack() {
        this.maxFreq = 0;
        this.freq2stack = new HashMap<>();
        this.freqs = new HashMap<>();
    }
    
    public void push(int val) {
        final var newFreq = freqs.getOrDefault(val, 0) + 1;
        freqs.put(val, newFreq);
        freq2stack.computeIfAbsent(newFreq, k -> new ArrayDeque<>()).offerLast(val);
        maxFreq = Math.max(maxFreq, newFreq);
    }
    
    public int pop() {
        final var stack = freq2stack.get(maxFreq);
        final var val = stack.pollLast();
        freqs.put(val, maxFreq-1);
        if (stack.isEmpty()) maxFreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
