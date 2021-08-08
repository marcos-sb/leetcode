class Solution {
    public int connectSticks(int[] sticks) {
        final var pq = new PriorityQueue<Integer>(sticks.length);
        for (var st : sticks) pq.offer(st);
        
        var cost = 0;
        while (pq.size() > 1) {
            final var first = pq.poll();
            final var second = pq.poll();
            final var merged = first + second;
            cost += merged;
            pq.offer(merged);
        }
        
        return cost;
    }
}
