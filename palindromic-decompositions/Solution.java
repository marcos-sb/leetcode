class Solution {
  public List<List<String>> partition(String s) {
    final List<List<String>> res = new ArrayList<>();
    rec(s, 0, new ArrayList<>(), res);
    return res;
  }

  private static void rec(String s, int i, List<String> decomp, List<List<String>> res) {
    if (i == s.length()) {
      res.add(new ArrayList<>(decomp));
      return;
    }

    for (int j = 1; i+j <= s.length(); j++) {
      final String sub = s.substring(i, i+j);
      if (!isPalindrome(sub)) continue;
      decomp.add(sub);
      rec(s, i+j, decomp, res);
      decomp.remove(decomp.size()-1);
    }
  }

  private static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length()/2; i++) {
      if (s.charAt(i) != s.charAt(s.length()-i-1))
        return false;
    }
    return true;
  }
}
