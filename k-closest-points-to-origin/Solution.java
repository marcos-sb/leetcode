class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final var cache = new int[points.length];
        final Comparator<Integer> cmp = (i,j) -> Integer.compare(cache[j], cache[i]);
        final var pq = new PriorityQueue<Integer>(cmp);
        
        for (int i = 0; i < points.length; i++) {
            final var p = points[i];
            cache[i] = distOrigin(p);
            if (pq.size() < k) pq.offer(i);
            else {
                if (cache[i] < cache[pq.peek()]) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        
        final int[][] res = new int[k][];
        int i = 0;
        while (!pq.isEmpty())
            res[i++] = points[pq.poll()];
        
        return res;
    }
    
    private static int distOrigin(int[] a) {
        return Math.abs(a[0]) + Math.abs(a[1]);
    }
}
