class Solution {
    public int lastStoneWeight(int[] stones) {
        final var pq = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        for (var s : stones) pq.offer(s);
        while (!pq.isEmpty()) {
            final var y = pq.poll();
            if (pq.isEmpty()) return y;
            final var x = pq.poll();
            final var z = y - x;
            if (0 < z) pq.offer(z);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
