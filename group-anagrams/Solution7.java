class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var groupByFrequencyMap = new HashMap<Map<Character, Integer>, Integer>();
        final List<List<String>> res = new ArrayList<>();
        for (var s : strs) {
            final var frequencyMap = buildFrequencyMap(s);
            groupByFrequencyMap.putIfAbsent(frequencyMap, groupByFrequencyMap.size());
            final var groupIndex = groupByFrequencyMap.get(frequencyMap);
            if (res.size() <= groupIndex) {
                res.add(new ArrayList<>());
            }
            res.get(groupIndex).add(s);
        }
        return res;
    }

    private static Map<Character, Integer> buildFrequencyMap(String s) {
        final var res = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            res.put(c, res.getOrDefault(c, 0) + 1);
        }
        return res;
    }
}
