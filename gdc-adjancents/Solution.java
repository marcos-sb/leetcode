class Solution {
  public int gcdAdjacents(int[] A) {
    int ones = 0;
    for (int a : A) if (a == 1) ones++;
    if (ones > 0) return A.length - ones;

    int minRegion = A.length + 1;
    for (int l = 0; l < A.length; l++) {
      int runningGCD = A[l];
      for (int r = l+1; r < A.length; r++) {
        runningGCD = gcd(runningGCD, A[r]);
        if (runningGCD == 1) {
          minRegion = Math.min(minRegion, r-l+1);
          break;
        }
      }
    }

    if (minRegion == A.length + 1) return -1;

    return minRegion - 1 + A.length - 1;
  }

  private static int gcd(int a, int b) {
    while (a != 0 && b != 0)
      if (a > b) a %= b;
      else b %= a;
    return a == 0 ? b : a;
  }
}
