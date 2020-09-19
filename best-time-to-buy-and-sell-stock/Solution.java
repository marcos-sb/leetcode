class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        return mp(prices, 0, prices[0]);
    }
    private static int mp(int[] prices, int i, int minSoFar) {
        if (i == prices.length) return 0;
        return Math.max(prices[i] - minSoFar, mp(prices, i+1, Math.min(prices[i], minSoFar)));
    }
}
