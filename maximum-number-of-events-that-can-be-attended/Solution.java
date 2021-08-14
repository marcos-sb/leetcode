class Solution {
    public int maxEvents(int[][] events) {
        final var N = events.length;
        if (events == null) return 0;
        
        final Comparator<int[]> cmp = (a,b) -> Integer.compare(a[0], b[0]);
        Arrays.sort(events, cmp);
        
        final var pq = new PriorityQueue<Integer>();
        int i = 0;
        int d = 0;
        int count = 0;
        while (!pq.isEmpty() || i < N) {
            if (pq.isEmpty()) d = events[i][0];
            while (!pq.isEmpty() && pq.peek() < d) pq.poll();
            while (i < N && events[i][0] == d) pq.offer(events[i++][1]);
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            d++;
        }
        
        return count;
    }
}
