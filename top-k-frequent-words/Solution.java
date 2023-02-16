class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        final var counts = new HashMap<String, Integer>();
        for (var w : words)
            counts.put(w, counts.getOrDefault(w, 0) + 1);

        final Comparator<String> rankCmp =
            (s,t) -> Integer.compare(counts.get(s), counts.get(t));
        final Comparator<String> rankLexCmp =
            rankCmp.thenComparing((s,t) -> t.compareTo(s));
        final var pq = new PriorityQueue<String>(rankLexCmp);
        for (var w : counts.keySet()) {
            pq.offer(w);
            if (k < pq.size()) pq.poll();
        }

        final var res = new LinkedList<String>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }

        return res;
    }
}
