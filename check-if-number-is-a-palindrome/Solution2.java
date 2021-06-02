class Solution2 {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    final var places = (int) Math.ceil(Math.log10(x));
    var mask = (int) Math.pow(10, places-1);
    for (var i = 0; i < places/2; i++) {
      final var left = x / mask;
      final var right = x % 10;
      if (left != right) return false;
      x %= mask;
      x /= 10;
      mask /= 100;
    }
    return true;
  }
}
