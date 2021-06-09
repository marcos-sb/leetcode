class Solution {
  public int longestSubstringWithAtMostKDistinctCharacters(String s, int k) {
    if (s == null) return -1;
    if (s.length() <= k) return s.length();

    var l = 0;
    var r = 0;
    var max = 0;
    final var windowFreqs = new HashMap<Character, Integer>();
    while (r < s.length()) {
      final var cr = s.charAt(r);
      windowFreqs.put(cr, windowFreqs.getOrDefault(cr,0)+1);
      if (windowFreqs.size() > k) {
        final var cl = s.charAt(l++);
        final var clFreq = windowFreqs.get(cl);
        if (clFreq == 1) windowFreqs.remove(cl);
        else windowFreqs.put(cl, clFreq-1);
      }
      max = Math.max(max, r-l+1);
      r++;
    }

    return max;
  }
}
