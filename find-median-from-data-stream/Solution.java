class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    }

    public void addNum(int num) { // O(log(max(N,M)) + O(rebalance))
        if (maxHeap.isEmpty()) maxHeap.offer(num); 
        else {
            if (num <= maxHeap.peek()) maxHeap.offer(num);
            else minHeap.offer(num);
        }
        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) rebalance();
    }

    private void rebalance() { // O(log(N) + log(M)) => O(log(N*M))
        final var smallest = maxHeap.size() < minHeap.size() ? maxHeap : minHeap;
        final var biggest = maxHeap == smallest ? minHeap : maxHeap;
        smallest.offer(biggest.poll());
    }
    
    public double findMedian() {
        final var N = minHeap.size();
        final var M = maxHeap.size();
        if (N == 0 && M == 0) return 0d;
        if (N == M) return ((double) minHeap.peek() + maxHeap.peek()) / 2;
        return N < M ? maxHeap.peek() : minHeap.peek();
    }
}

