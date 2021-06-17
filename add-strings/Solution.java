class Solution {
  public String addStrings(String s1, String s2) {
    final var sb = new StringBuilder();
    final var longest = s1.length() >= s2.length() ? s1 : s2;
    final var shortest = longest == s1 ? s2 : s1;
    var i = longest.length()-1;
    var j = shortest.length()-1;
    var carry = 0;
    while (j >= 0) {
      final var ni = longest.charAt(i--) - '0';
      final var nj = shortest.charAt(j--) - '0';
      final var sum = ni + nj + carry;
      sb.append(sum % 10);
      carry = sum / 10;
    }

    while (i >= 0) {
      final var ni = longest.charAt(i--) - '0';
      final var sum = ni + carry;
      sb.append(sum % 10);
      carry = sum / 10;
    }

    if (carry > 0) sb.append(carry);
    
    return sb.reverse().toString();
  }
}
