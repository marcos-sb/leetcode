class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (var n : nums) {
            minHeap.offer(n);
            if (k < minHeap.size()) minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (k < minHeap.size()) minHeap.poll();
        return minHeap.peek();
    }
}
