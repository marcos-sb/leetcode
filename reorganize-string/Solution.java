class Solution {
    public String reorganizeString(String s) {
        final var N = s.length();
        
        final var freqs = new HashMap<Character, Integer>();
        for (var i = 0; i < N; i++) // O(N)
            freqs.compute(s.charAt(i), (c, f) -> f == null ? 1 : f+1);
        
        final var maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
            (e1,e2) -> Integer.compare(e2.getValue(), e1.getValue()));
        for (var entry : freqs.entrySet()) maxHeap.offer(entry); // O(1*log(1))

        Map.Entry prev = null;
        final var res = new StringBuilder();
        while (!maxHeap.isEmpty()) { // O(N*log(1))
            final var topFreq = maxHeap.poll();
            res.append(topFreq.getKey());
            
            if (prev != null) maxHeap.offer(prev);
            if (1 < topFreq.getValue()) {
                topFreq.setValue(topFreq.getValue()-1);
                prev = topFreq;
            } else prev = null;
        }

        return res.length() == N ? res.toString() : "";
    }
}
