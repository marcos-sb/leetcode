class Solution {
  public boolean verifyOrdering(List<String> A, String ordering) {
    if (A == null || ordering == null || A.isEmpty()) return false;

    final var char2idx = new HashMap<Character, Integer>();
    var idx = 0;
    for (var i = 0; i < ordering.length(); i++)
      char2idx.put(ordering.charAt(i), idx++);
    
    var prev = A.get(0);
    for (var i = 1; i < A.size(); i++) {
      var curr = A.get(i);
      final var minLen = Math.min(prev.length(), curr.length());
      var equal = true;
      for (var j = 0; j < minLen; j++) {
        final var cp = prev.charAt(j);
        final var cc = curr.charAt(j);
        equal &= (cp == cc);
        if (char2idx.get(cp) < char2idx.get(cc)) break;
        if (char2idx.get(cp) > char2idx.get(cc)) return false;
      }
      if (equal && prev.length() > curr.length()) return false;
      prev = curr;
    }

    return true;
  }
}
