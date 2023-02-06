class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        var maxProfit = 0;
        var minSoFar = prices[0];
        for (var i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return maxProfit;
    }
}
