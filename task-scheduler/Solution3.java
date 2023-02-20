class Solution {
    public int leastInterval(char[] tasks, int n) {
        final var counts = new int['Z'-'A'+1]; 
        for (var c : tasks) counts[c-'A']++;
        final Comparator<Integer> cmp = (a,b) -> Integer.compare(b, a);
        final var pq = new PriorityQueue<Integer>(cmp);
        for (var c : counts) if (c > 0) pq.offer(c);
        
        final var buf = new int['Z'-'A'+1];
        var totalCount = 0;
        var count = 0;
        while (!pq.isEmpty()) {
            count = 0;
            while (count <= n && !pq.isEmpty())
                buf[count++] = pq.poll();
            totalCount += n+1;
            for (var i = 0; i < count; i++)
                if (buf[i]-1 > 0) pq.offer(buf[i]-1);
        }
        
        return totalCount - n-1 + count;
    }
}
