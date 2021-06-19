class Solution {
  public String addBinaryStrings(String s1, String s2) {
    final var sb = new StringBuilder();
    var i = s1.length()-1;
    var j = s2.length()-1;
    var carry = 0;
    while (i >= 0 || j >= 0) {
      final var s1i = i >= 0 ? s1.charAt(i) - '0' : 0;
      final var s2j = j >= 0 ? s2.charAt(j) - '0' : 0;
      final var sum = s1i + s2j + carry;
      carry = sum / 2;
      sb.append(sum % 2);
      i--; j--;
    }
    if (carry > 0) sb.append(carry);
    
    return sb.reverse().toString();
  }
}
