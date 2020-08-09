class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> int2freq = new HashMap<>();
        for (int num : nums)
            int2freq.put(num, int2freq.computeIfAbsent(num, __ -> 0)+1);
        
        final PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt((int[] intfreq) -> intfreq[1]));
        
        pq.offer(new int[]{0,0});
        for (var entry : int2freq.entrySet()) {
            if (pq.size() < k) {
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
                continue;
            }
            if (pq.peek()[1] < entry.getValue()) {
                pq.poll();
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        
        final int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.poll()[0];
        }
        
        return res;
    }
}
