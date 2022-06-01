class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var anagramsByClass = new HashMap<String, List<String>>(strs.length);
        for (var s : strs)
            anagramsByClass.computeIfAbsent(anagram(s), (k) -> new ArrayList<>()).add(s);
        
        return new ArrayList<>(anagramsByClass.values());
    }
    
    private static String anagram(String s) {
        final var res = new char['z'-'a'+1];
        for (var i = 0; i < s.length(); i++)
            res[s.charAt(i)-'a']++;
        return new String(res);
    }
}
