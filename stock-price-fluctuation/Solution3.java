import java.util.NavigableMap;

class StockPrice {
    private final PriorityQueue<int[]> maxHeap;
    private final PriorityQueue<int[]> minHeap;
    private final Map<Integer, Integer> priceByTimestamp;

    int currentTimestamp;
    int currentPrice;

    public StockPrice() {
        this.maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[1], a[1])
        );
        this.minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        this.priceByTimestamp = new HashMap<>();
        this.currentTimestamp = 0;
        this.currentPrice = 0;
    }

    public void update(int timestamp, int price) {
        if (currentTimestamp <= timestamp) {
            currentTimestamp = timestamp;
            currentPrice = price;
        }

        priceByTimestamp.put(timestamp, price);
        final var arr = new int[]{timestamp, price};
        maxHeap.offer(arr);
        minHeap.offer(arr);
    }

    public int current() {
        return currentPrice;
    }

    public int maximum() {
        while (!maxHeap.isEmpty()) {
            final var max = maxHeap.peek();
            if (max[1] != priceByTimestamp.get(max[0])) maxHeap.poll();
            else break;
        }
        return maxHeap.peek()[1];
    }

    public int minimum() {
        while (!minHeap.isEmpty()) {
            final var min = minHeap.peek();
            if (min[1] != priceByTimestamp.get(min[0])) minHeap.poll();
            else break;
        }
        return minHeap.peek()[1];
    }
}
