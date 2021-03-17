class Solution2 {
    private int maxProfit = 0;
    
    public int maxProfit(int[] prices) {
        mpRec(prices, 0, prices[0]);
        return maxProfit;
    }
    
    private int mpRec(int[] prices, int day, int minPrice) {
        if (day == prices.length) return 0;
        final var maxPrice = mpRec(prices, day+1, Math.min(minPrice, prices[day]));
        final var sellProfit = prices[day] - minPrice;
        maxProfit = Math.max(maxProfit, sellProfit);
        return Math.max(maxPrice, prices[day]);
    }
}
