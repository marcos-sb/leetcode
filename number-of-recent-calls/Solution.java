// @NotThreadSafe
class RecentCounter {
    private int tailSize;
    private int totalSoFar;
    private final Deque<Integer> timestamps;
    
    public RecentCounter() {
        this.tailSize = 3000;
        this.totalSoFar = 0;
        this.timestamps = new LinkedList<>();
    }
    
    public int ping(int t) {
        if (!timestamps.isEmpty() && timestamps.getLast() < t-tailSize) {
            timestamps.clear();
            totalSoFar = 0;
        }
        
        while (!timestamps.isEmpty() && timestamps.getFirst() < t-tailSize) {
            timestamps.removeFirst();
            totalSoFar--;
        }
        timestamps.addLast(t);
        totalSoFar++;
        
        return totalSoFar;
    }
}
