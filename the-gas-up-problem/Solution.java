class Solution {
  public int findStartStation(int[] gas, int[] cost) {
    final int N = gas.length;
    int sum = 0;
    for (int i = 0; i < N; i++)
      sum += gas[i] - cost[i];
    if (sum < 0) return -1;

    int start = 0;
    int tank = 0;
    for (int i = 0; i < N; i++) {
      tank += gas[i] - cost[i];
      if (tank < 0) {
        tank = 0;
        start = i+1;
      }
    }

    return start;
  }
}
