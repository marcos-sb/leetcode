class Solution {
    private static final int[] daysPass = new int[]{1, 7, 30};
    
    public int mincostTickets(int[] days, int[] costs) {
        return minCostTickets(days, 0, costs, new int[days.length]);
    }
    
    private static int minCostTickets(int[] days, int i,  int[] costs, int[] minCosts) {
        if (i >= days.length) return 0;
        if (minCosts[i] > 0) return minCosts[i];
        
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < costs.length; j++) {
            final int cost = costs[j];
            final int startDay = days[i];
            int k = i+1;
            while (k < days.length && days[k] - startDay < daysPass[j]) { k++; }
            minCost = Math.min(minCost, cost + minCostTickets(days, k, costs, minCosts));
        }
        minCosts[i] = minCost;
        
        return minCosts[i];
    }
}
