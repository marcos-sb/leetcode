class Solution {
  public boolean powerOfTwo(int input) {
    var ones = 0;
    while (input > 0 && ones < 2) {
      ones += input & 1;
      input >>>= 1;
    }
    return ones == 1;
  }
}
