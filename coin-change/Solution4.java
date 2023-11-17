class Solution {
    public int coinChange(int[] coins, int amount) {
        final var cache = new int[amount+1];
        return dp(coins, amount, cache);
    }

    private static int dp(int[] coins, int amountLeft, int[] cache) {
        if (amountLeft == 0) return 0;
        if (cache[amountLeft] != 0) return cache[amountLeft];
        
        var min = Integer.MAX_VALUE;
        for (var c : coins) {
            if (amountLeft < c) continue;
            final var prev = dp(coins, amountLeft - c, cache);
            if (prev == -1) continue;
            min = Math.min(min, 1 + prev);
        }

        return cache[amountLeft] = min == Integer.MAX_VALUE ? -1 : min;
    }
}
