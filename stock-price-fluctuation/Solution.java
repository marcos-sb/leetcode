import java.util.NavigableMap;

class StockPrice {
    private final NavigableMap<Integer, Integer> priceByTimestamp;
    private final NavigableMap<Integer, Integer> countByPrice;

    public StockPrice() {
        this.priceByTimestamp = new TreeMap<>();
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
    }

    public int current() {
        return priceByTimestamp.lastEntry().getValue();
    }

    public int maximum() {
        return countByPrice.lastKey();
    }

    public int minimum() {
        return countByPrice.firstKey();
    }
}
