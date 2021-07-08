class Solution2 {
  public int totalWaysToReachScore(int finalScore, int[] pointEvents) {
    if (finalScore <= 0 || pointEvents == null || pointEvents.length < 1) return 0;
    final int[][] cache = new int[pointEvents.length+1][finalScore+1];
    for (int i = 0; i < cache.length; i++)
      Arrays.fill(cache[i], -1);
    return dp(finalScore, pointEvents, pointEvents.length, cache);
  }

  private static int dp(int finalScore, int[] pointEvents, int i, int[][] cache) {
    if (i == 0 || finalScore < 0) return 0;
    if (finalScore == 0) return 1;

    if (cache[i][finalScore] != -1) return cache[i][finalScore];
    
    final int withoutI = dp(finalScore, pointEvents, i-1, cache);
    final int withI = dp(finalScore-pointEvents[i-1], pointEvents, i, cache);

    return cache[i][finalScore] = withI + withoutI;
  }
}
