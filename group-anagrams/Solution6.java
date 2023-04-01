class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> _class = new HashMap<>();
        for (var s : strs) {
            final var sArr = s.toCharArray();
            Arrays.sort(sArr);
            final var sortedS = String.valueOf(sArr);
            _class.computeIfAbsent(sortedS, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(_class.values());
    }
}
