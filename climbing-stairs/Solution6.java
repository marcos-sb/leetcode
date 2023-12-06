class Solution {
    public int climbStairs(int n) {
        final var cache = new int[n+1];
        return rec(n, cache);
    }

    private static int rec(int n, int[] cache) {
        if (n < 2) return 1;
        if (cache[n] != 0) return cache[n];
        return cache[n] = rec(n-1, cache) + rec(n-2, cache); // O(n)
    }
}

