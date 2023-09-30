class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var N = nums.length;
        final var freqs = new HashMap<Integer, Integer>();
        for (var n : nums) freqs.compute(n, (num, f) -> f == null ? 1 : f+1); // O(N)

        final var minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(
            (e1,e2) -> Integer.compare(e1.getValue(), e2.getValue()));
        for (var e : freqs.entrySet()) { // O(F*log(k))
            minHeap.offer(e);
            if (k < minHeap.size()) minHeap.poll();
        }

        final var res = new int[k];
        var j = 0;
        while (!minHeap.isEmpty()) // O(k*log(k))
            res[j++] = minHeap.poll().getKey();

        return res;
    }
}
