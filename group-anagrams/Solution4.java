class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, Integer> _class = new HashMap<>();
        final List<List<String>> res = new ArrayList<>();
        for (var s : strs) {
            final var freqs = toFreqMap(s);
            if (!_class.containsKey(freqs)) {
                _class.put(freqs, res.size());
                res.add(new ArrayList<>());
            }
            res.get(_class.get(freqs)).add(s);
        }
        return res;
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
