class Solution {
    public int coinChange(int[] coins, int amount) {
        return cc(coins, amount, new HashMap<>());
    }

    private static int cc(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        
        if (cache.containsKey(amount)) return cache.get(amount);

        var minCoins = Integer.MAX_VALUE;
        for (var c : coins) {
            final var res = cc(coins, amount-c, cache);
            if (res >= 0 && res < minCoins) {
                minCoins = res + 1;
            }
        }
        cache.put(amount, minCoins < Integer.MAX_VALUE ? minCoins : -1);
        
        return minCoins < Integer.MAX_VALUE ? minCoins : -1;
    }
}
