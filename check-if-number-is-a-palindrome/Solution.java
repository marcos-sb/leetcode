class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    return rev(x) == x;
  }

  private static int rev(int n) {
    int res = 0;
    int absN = Math.abs(n);
    int sign = absN/n;
    while (absN != 0) {
      res *= 10;
      res += absN % 10;
      absN /= 10;
    }
    return sign * res;
  }
}
