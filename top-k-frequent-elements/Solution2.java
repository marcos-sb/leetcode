class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var freqs = new HashMap<Integer, Integer>();
        for (var n : nums)
            freqs.put(n,freqs.getOrDefault(n,0)+1);

        final var pq = new PriorityQueue<Integer>(k+1, (a,b) -> Integer.compare(freqs.get(a), freqs.get(b)));
        for (var entry : freqs.entrySet()) {
            pq.offer(entry.getKey());
            if (k < pq.size()) pq.poll();
        }
        
        final var res = new int[k];
        var i = 0;
        while (!pq.isEmpty()) res[i++] = pq.poll();
        
        return res;
    }
}
