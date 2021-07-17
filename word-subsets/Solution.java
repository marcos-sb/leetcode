class Solution {
  public List<String> wordSubsets(List<String> A, List<String> B) {
    final Map<Character, Integer> freqsB = buildMaxFreqs(B);

    final List<String> res = new ArrayList<>();
    for (String sa : A) {
      final Map<Character, Integer> freqsSA = buildFreqs(sa);
      if (isSuperSet(freqsSA, freqsB)) res.add(sa);
    }

    return res;
  }
  
  private static Map<Character, Integer> buildMaxFreqs(List<String> ls) {
    final Map<Character, Integer> maxFreqs = new HashMap<>();
    for (String s : ls) {
      final Map<Character, Integer> freqsS = buildFreqs(s);
      for (Map.Entry<Character, Integer> entry : freqsS.entrySet()) {
        final char key = entry.getKey();
        final int val = entry.getValue();
        if (!maxFreqs.containsKey(key)) maxFreqs.put(key, val);
        else {
          final int maxFreqsVal = maxFreqs.get(key);
          final int globalMaxFreq = Math.max(maxFreqsVal, val);
          maxFreqs.put(key, globalMaxFreq);
        }
      }
    }
    return maxFreqs;
  }

  private static Map<Character, Integer> buildFreqs(String s) {
    final Map<Character, Integer> freqs = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      freqs.put(c, freqs.getOrDefault(c, 0) + 1);
    }
    return freqs;
  }

  private static boolean isSuperSet(Map<Character, Integer> superset, Map<Character, Integer> set) {
    if (superset.size() < set.size()) return false;
    for (Map.Entry<Character, Integer> setEntry : set.entrySet()) {
      final char setKey = setEntry.getKey();
      final int setVal = setEntry.getValue();
      if (!superset.containsKey(setKey)) return false;
      final int supersetVal = superset.get(setKey);
      if (supersetVal < setVal) return false;
    }
    return true;
  }
}
