class Solution {
    public String reorganizeString(String s) {
        final var N = s.length();
        
        final var freqs = new int['z'-'a'+1];
        for (var i = 0; i < N; i++)
            freqs[s.charAt(i)-'a']++;
        
        final var maxHeap = new PriorityQueue<Integer>(
            (i,j) -> Integer.compare(freqs[j], freqs[i]));
        for (var i = 0; i < freqs.length; i++) if (0 < freqs[i]) maxHeap.offer(i);

        var prevI = -1;
        final var res = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            final var topFreqI = maxHeap.poll();
            res.append((char)(topFreqI+'a'));
            
            if (-1 < prevI) maxHeap.offer(prevI);
            if (1 < freqs[topFreqI]) {
                freqs[topFreqI]--;
                prevI = topFreqI;
            } else prevI = -1;
        }

        return res.length() == N ? res.toString() : "";
    }
}
