class Solution {
  public String changeBase(String numAsString, int b1, int b2) {
    return decimalToBase(baseToDecimal(numAsString, b1), b2);
  }
  
  private static int baseToDecimal(String num, int b) {
    int decimal = 0;
    for (int i = 0; i < num.length(); i++) { // O(num)
      int digit = num.charAt(i) - '0';
      if (digit > 9) digit = num.charAt(i) - 'A' + 10;
      decimal *= b;
      decimal += digit;
    }
    return decimal;
  }

  private static String decimalToBase(int num, int b) {
    final StringBuilder sb = new StringBuilder();
    while (num >= b) {
      sb.append(intToChar(num % b, b));
      num /= b;
    }
    sb.append(num);
    return sb.reverse().toString();
  }

  private static char intToChar(int decimal, int b) {
    if (decimal < 10) return (char)(decimal + '0');
    return (char)((decimal - 10) + 'A');
  }
}
