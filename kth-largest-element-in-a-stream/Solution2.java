class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int sizeLimit;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        sizeLimit = k;
        for (var n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (sizeLimit < minHeap.size()) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
