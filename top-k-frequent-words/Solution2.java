class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // final var S = Math.max(len(w), w <- words);
        final var N = words.length;
        
        final var freqs = new HashMap<String, Integer>();
        for (var w : words) freqs.compute(w, (word, count) -> count == null ? 1 : count+1); // O(N)
        // final var F = freqs.size();
        
        final Comparator<String> lexCmp = Comparator.naturalOrder();
        final var minHeap = new PriorityQueue<Map.Entry<String,Integer>>(
            (e1,e2) -> {
                final var cmpCount = Integer.compare(e1.getValue(), e2.getValue()); // O(1)
                return cmpCount == 0 ? lexCmp.compare(e2.getKey(), e1.getKey()) : cmpCount; // O(S)
            });
        for (var e : freqs.entrySet()) { // O(F*S*log(k))
            minHeap.offer(e); // O(S*log(k))
            if (k < minHeap.size()) minHeap.poll();
        }

        final var res = new ArrayList<String>(k);
        while (!minHeap.isEmpty()) res.add(minHeap.poll().getKey()); // O(log(k))
        Collections.reverse(res); // O(k)
        return res;
    }
}
