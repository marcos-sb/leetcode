class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> _class = new HashMap<>();
        for (var s : strs) {
            final var freqs = toFreqMap(s);
            _class.computeIfAbsent(freqs, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(_class.values());
    }

    private static Map<Character, Integer> toFreqMap(String s) {
        final var res = new HashMap<Character, Integer>();
        final var S = s.length();
        for (var i = 0; i < S; i++) {
            final var c = s.charAt(i);
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }
}
