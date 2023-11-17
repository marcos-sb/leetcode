import java.util.*;

class FindMaxKnapsackProfit {
    public static int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        final var N = weights.length;
        final var cache = new int[N][capacity+1];
        return dp(N-1, weights, values, capacity, cache);
    }

    private static int dp(int i, int[] w, int[] v, int capLeft, int[][] cache) {
        if (i < 0 || capLeft == 0) return 0;
        if (0 < cache[i][capLeft]) return cache[i][capLeft];
        if (0 <= capLeft - w[i])
            return cache[i][capLeft] = Math.max(v[i] + dp(i-1, w, v, capLeft-w[i], cache), dp(i-1, w, v, capLeft, cache));
        return cache[i][capLeft] = dp(i-1, w, v, capLeft, cache);
    }
}
