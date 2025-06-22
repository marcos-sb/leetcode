class FreqStack {
    private final Map<Integer, Deque<Integer>> stackByFreq;
    private final Map<Integer, Integer> numByFreq;
    private int maxFreq;

    public FreqStack() {
        this.stackByFreq = new HashMap<>();
        this.numByFreq = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        final var newFreq = numByFreq.getOrDefault(val, 0) + 1;
        numByFreq.put(val, newFreq);
        stackByFreq
            .computeIfAbsent(newFreq, k -> new ArrayDeque<>())
            .push(val);
        maxFreq = Math.max(maxFreq, newFreq);
    }

    public int pop() {
        final var maxFreqStack = stackByFreq.get(maxFreq);
        final var ret = maxFreqStack.pop();
        numByFreq.put(ret, maxFreq-1);
        if (maxFreqStack.isEmpty())
            --maxFreq;
        return ret;
    }
}
