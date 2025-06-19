import java.util.NavigableMap;

class StockPrice {
    int currentTimestamp = 0;
    int currentPrice = 0;

    private final Map<Integer, Integer> priceByTimestamp;
    private final NavigableMap<Integer, Integer> countByPrice;

    public StockPrice() {
        this.priceByTimestamp = new HashMap<>();
        this.countByPrice = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        final var oldPrice = priceByTimestamp.put(timestamp, price);

        if (oldPrice != null) {
            final var oldPriceCount = countByPrice.get(oldPrice);
            if (oldPriceCount == 1) {
                countByPrice.remove(oldPrice);
            } else {
                countByPrice.put(oldPrice, oldPriceCount-1);
            }
        }
        countByPrice.put(price, countByPrice.getOrDefault(price, 0) + 1);

        if (currentTimestamp <= timestamp) {
            currentTimestamp = timestamp;
            currentPrice = price;
        }
    }

    public int current() {
        return currentPrice;
    }

    public int maximum() {
        return countByPrice.lastKey();
    }

    public int minimum() {
        return countByPrice.firstKey();
    }
}
