class Solution {
  public boolean powerOfFour(int input) {
    return input != 0 && (input & (input - 1)) == 0 && (input & 0x55555555) == input;
  }
}
