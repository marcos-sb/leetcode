class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var groups = new HashMap<String, Integer>();
        final List<List<String>> res = new ArrayList<>();
        for (var str : strs) {
            final var chars = str.toCharArray();
            Arrays.sort(chars);
            final var sortedStr = new String(chars);
            groups.putIfAbsent(sortedStr, groups.size());
            final var group = groups.get(sortedStr);
            if (res.size() <= group) {
                res.add(new ArrayList<>());
            }
            res.get(group).add(str);
        }
        return res;
    }
}
