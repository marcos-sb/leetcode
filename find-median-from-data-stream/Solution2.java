class MedianFinder {
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }

    public void addNum(int num) {
        if (maxHeap.size() <= minHeap.size())
            maxHeap.offer(num);
        else
            minHeap.offer(num);
        if (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
            final var tmp = maxHeap.poll();
            maxHeap.offer(minHeap.poll());
            minHeap.offer(tmp);
        }
    }

    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return Double.NaN;
        if (minHeap.size() < maxHeap.size()) return maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek()) / 2D;
    }
}
