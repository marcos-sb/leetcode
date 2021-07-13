class Solution {
  public int minimumStepsToReachOne(int input) {
    int ops = 0;
    while (input > 0) {
      ops += (input & 1) + 1;
      input >>>= 1;
    }
    return ops - 2;
  }
}
