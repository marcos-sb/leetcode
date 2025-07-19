class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var n = strs.length;
        final var indexByGroup = new HashMap<String, Integer>();
        final List<List<String>> groups = new ArrayList<>();
        for (var s : strs) {
            final var chars = s.toCharArray();
            Arrays.sort(chars);
            final var sortedS = new String(chars);
            indexByGroup.putIfAbsent(sortedS, indexByGroup.size());
            final var index = indexByGroup.get(sortedS);
            if (groups.size() <= index)
                groups.add(new ArrayList<>());
            groups.get(index).add(s);
        }
        return groups;
    }
}
