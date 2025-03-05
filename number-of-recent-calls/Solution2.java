class RecentCounter {
    private static final int WINDOW_LENGTH_MS = 3000;
    private final Deque<Integer> history;

    public RecentCounter() {
        history = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!history.isEmpty() && history.peek() < t - WINDOW_LENGTH_MS) {
            history.poll();
        }
        history.offer(t);
        return history.size();
    }
}
