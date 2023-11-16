class FindMaxKnapsackProfit {
    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        final var M = values.length; // rows <- items considered
        final var N = capacity;      // cols <- consumed weight
        final var dp = new int[M+1][N+1];

        for (var r = 0; r <= M; r++) dp[r][0] = 0;
        for (var c = 0; c <= N; c++) dp[0][c] = 0;
        for (var r = 1; r <= M; r++) {
            for (var c = 1; c <= N; c++) {
                // On each cell we're going write the max value of the bag considering:
                // [1] the elements up to the r-1th
                // [2] the weight up to c

                // If the weight of the current item (r-1) is higher than the max current weight
                // I'm considering (c), I can't add the item to the backpack. So the max value of
                // the backpack has to be the same value it had without the current item.
                // That value is on the cell right above the current one.
                if (c < weights[r-1]) dp[r][c] = dp[r-1][c];

                // If the weight of the current item is lower than the max weight I'm considering,
                // I could add the item to the backpack because it might increase the total value
                // in the backpack. So, the max value for that cell would be the max value considering:
                // [1] I add the item to the backpack.
                // [2] I don't add the item.
                //
                // [1] Means: The new total value of the backpack is the value of the backpack before
                // I added the item (dp[r-1][c-weights[r-1]]), plus the value of the item. The row
                // in dp is the one before the one we're currently considering, because that row
                // includes all of the items except the one we're currently considering. The column
                // (which represents the current weight of the backpack) is the current column minus
                // the weight of the item we're considering.
                else dp[r][c] = Math.max(values[r-1] + dp[r-1][c-weights[r-1]], dp[r-1][c]);
            }
        }

        // We return the max value of the backpack with weight 'capacity' (col <- N)
        // and having considered all the items (row <- M).
        return dp[M][N];
    }
}
