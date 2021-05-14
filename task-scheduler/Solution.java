public class Solution {
    public int leastInterval(char[] tasks, int n) {
        final Map<Character, Integer> freqs = new HashMap<>();
        for (char t : tasks)
            freqs.put(t, freqs.getOrDefault(t, 0) + 1);
        
        final Comparator<Character> cmp = (a,b) -> Integer.compare(freqs.get(b), freqs.get(a));
        final PriorityQueue<Character> pq = new PriorityQueue<>(cmp);
        for (Character f : freqs.keySet()) pq.offer(f);
        
        int intervals = 0;
        int reqSlotSize = n+1;
        final Queue<Character> slot = new LinkedList<>();
        while (true) {
            while (!pq.isEmpty() && slot.size() < reqSlotSize) {
                final Character curr = pq.poll();
                final int freq = freqs.get(curr);
                if (freq > 1) freqs.put(curr, freq-1);
                else freqs.remove(curr);
                
                slot.offer(curr);
            }
            
            if (freqs.isEmpty()) {
                intervals += slot.size();
                break;
            }
            intervals += reqSlotSize;
            
            while (!slot.isEmpty()) {
                final Character curr = slot.poll();
                if (freqs.containsKey(curr)) pq.offer(curr);
            }
        }

        return intervals;
    }
}
