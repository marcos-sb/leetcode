class Solution {
    public int maxProfit(int[] prices) {
        final var n = prices.length;
        var maxProfit = 0;
        for (var i = 1; i < n; ++i) {
            if (prices[i-1] < prices[i]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
