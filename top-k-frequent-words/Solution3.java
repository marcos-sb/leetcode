class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        final var n = words.length;
        final var counts = new HashMap<String, Integer>();

        for (var word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        final var minHeap = new PriorityQueue<Map.Entry<String, Integer>>(
            (a, b) -> {
                final var byCount = Integer.compare(a.getValue(), b.getValue());
                if (byCount == 0) {
                    return b.getKey().compareTo(a.getKey());
                }
                return byCount;
            }
        );

        for (var entry : counts.entrySet()) {
            minHeap.offer(entry);
            if (k < minHeap.size()) {
                minHeap.poll();
            }
        }

        final var res = new LinkedList<String>();
        while (!minHeap.isEmpty()) {
            res.addFirst(minHeap.poll().getKey());
        }

        return res;
    }
}
