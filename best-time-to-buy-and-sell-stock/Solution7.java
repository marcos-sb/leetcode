class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        var maxProfit = 0;
        var minPrice = prices[0];
        for (var p : prices) {
            maxProfit = Math.max(maxProfit, p - minPrice);
            minPrice = Math.min(minPrice, p);
        }

        return maxProfit;
    }
}
