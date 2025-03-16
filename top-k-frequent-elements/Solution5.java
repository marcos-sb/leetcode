class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var counts = new HashMap<Integer, Integer>();
        final var minHeap = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[1], b[1]));

        for (var n : nums) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }
        for (var e : counts.entrySet()) {
            minHeap.offer(new int[]{e.getKey(), e.getValue()});
            if (k < minHeap.size()) minHeap.poll();
        }

        final var res = new int[k];
        var i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll()[0];
        }
        return res;
    }
}
