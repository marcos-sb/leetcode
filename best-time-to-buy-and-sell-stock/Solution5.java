class Solution {
    public int maxProfit(int[] prices) {
        final var N = prices.length;
        var maxProfit = 0;
        var buyPrice = Integer.MAX_VALUE;
        for (var i = 0; i < N; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-buyPrice);
        }
        return maxProfit;
    }
}
