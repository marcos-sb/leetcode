class Solution {
    public int nthUglyNumber(int n) {
        final long[] factors = {2,3,5};
        final Queue<Long> pq = new PriorityQueue<>();
        final Set<Long> gen = new HashSet<>(n);
        pq.add(1l);
        int count = 0;
        long u = 0;
        while (count < n) {
            u = pq.poll();
            count++;
            for (long f : factors) {
                if (!gen.contains(f*u)) {
                    pq.add(f*u);
                    gen.add(f*u);
                }
            }
        }
        return (int) u;
    }
}
