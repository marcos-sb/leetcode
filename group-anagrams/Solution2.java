class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var anagramsByClass = new HashMap<Map<Character, Integer>, List<String>>(strs.length);
        for (var s : strs)
            anagramsByClass.computeIfAbsent(anagram(s), (k) -> new ArrayList<>()).add(s);
        
        return new ArrayList<>(anagramsByClass.values());
    }
    
    private static Map<Character, Integer> anagram(String s) {
        final var res = new HashMap<Character, Integer>(26);
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }
}
