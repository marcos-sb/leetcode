class Solution {
  public List<List<String>> groupAnagrams(List<String> words) {
    final Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
    for (String w : words) {
      final Map<Character, Integer> anagramW = toAnagram(w);
      anagrams.computeIfAbsent(anagramW, k -> new ArrayList<>())
              .add(w);
    }
    
    final List<List<String>> res = new ArrayList<>();
    for (List<String> ls : anagrams.values()) {
      res.add(ls);
    }

    return res;
  }

  private static Map<Character, Integer> toAnagram(String s) {
    final Map<Character, Integer> anagram = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      anagram.put(c, anagram.getOrDefault(c,0)+1);
    }
    return anagram;
  }
}
