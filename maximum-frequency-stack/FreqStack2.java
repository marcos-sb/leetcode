import java.util.NavigableSet;

class FreqStack {
    private static record Info(int num, int freq, int index) {}

    private final NavigableSet<Info> stack;
    private final Map<Integer, Integer> freqByNum;
    private int index;

    public FreqStack() {
        this.stack = new TreeSet<>(
            (a,b) -> {
                final var byFreq = a.freq() - b.freq();
                if (byFreq != 0) return byFreq;
                return a.index() - b.index();
            }
        );
        this.freqByNum = new HashMap<>();
    }

    public void push(int val) {
        final var freq = freqByNum.getOrDefault(val, 0);
        final var info = new Info(val, freq+1, index++);
        stack.add(info);
        freqByNum.put(val, freq+1);
    }

    public int pop() {
        final var info = stack.pollLast();
        if (info.freq() == 1)
            freqByNum.remove(info.num());
        else
            freqByNum.put(info.num(), info.freq() - 1);

        return info.num();
    }
}
