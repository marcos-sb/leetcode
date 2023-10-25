class Solution {
    public int twoCitySchedCost(int[][] costs) {
        final var N = costs.length;
        
        var flyCost = 0;
        // Fly everyone to A
        for (var i = 0; i < N; i++) flyCost += costs[i][0];
        
        // Calculate the savings (fly to B instead of A)
        int[] savings = new int[N];
        for (var i = 0; i < N; i++) savings[i] = costs[i][1] - costs[i][0];

        // Pick the highest savings (non-descending sort) first
        Arrays.sort(savings);

        // Fly to B the people where we would save the most, but only half.
        // The other half should be flown to A.
        for (var i = 0; i < N/2; i++) flyCost += savings[i];

        return flyCost;
    }
}
