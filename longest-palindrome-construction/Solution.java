class Solution {
  public int longestPalindrome(String s) {
    if (s.length() <= 1) return s.length();

    final var freqs = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      final var c = s.charAt(i);
      freqs.put(c, freqs.getOrDefault(c, 0) + 1);
    }
    
    var oneOdd = 0;
    var maxLen = 0;
    for (var f : freqs.values()) {
      if (f % 2 == 0) maxLen += f;
      else {
        oneOdd = 1;
        maxLen += f-1;
      }
    }

    return maxLen + oneOdd;
  }
}
