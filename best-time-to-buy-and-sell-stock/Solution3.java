class Solution3 {
    public int maxProfit(int[] prices) {
        var min = Integer.MAX_VALUE;
        var maxProfit = 0;
        for (var i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        
        return maxProfit;
    }
}
