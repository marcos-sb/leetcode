class Solution {
  public int leastCoins(int[] coins, int amount) {
    if (coins == null || coins.length == 0) return 0;
    final int[] cache = new int[amount+1];
    Arrays.fill(cache, -2);
    return dp(coins, amount, cache);
  }

  private static int dp(int[] coins, int amount, int[] cache) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;

    if (cache[amount] != -2) return cache[amount];

    int min = Integer.MAX_VALUE;
    for (int c : coins) {
      final int res = dp(coins, amount - c, cache);
      if (res < 0) continue;
      min = Math.min(min, 1 + res);
    }

    return cache[amount] = (min == Integer.MAX_VALUE ? -1 : min);
  }
}
