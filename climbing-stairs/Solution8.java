class Solution {

    public int climbStairs(int n) {
        final var cache = new int[n + 1];
        return dp(n, new int[n + 1]);
    }

    private static int dp(int n, int[] cache) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] != 0) return cache[n];
        return cache[n] = dp(n - 1, cache) + dp(n - 2, cache);
    }
}
