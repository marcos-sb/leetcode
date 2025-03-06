class Solution {
    public String frequencySort(String s) {
        final var counts = new HashMap<Character, Integer>();
        var maxCount = 0;
        for (var c : s.toCharArray()) {
            final var newCount = counts.getOrDefault(c, 0) + 1;
            counts.put(c, newCount);
            maxCount = Math.max(maxCount, newCount);
        }
        final List<Character>[] buckets = new List[maxCount+1];
        for (var e : counts.entrySet()) {
            if (buckets[e.getValue()] == null)
                buckets[e.getValue()] = new ArrayList<>();
            buckets[e.getValue()].add(e.getKey());
        }
        final var res = new StringBuilder();
        for (var i = maxCount; 0 < i; i--)
            if (buckets[i] != null)
                for (var c : buckets[i])
                    for (var j = 0; j < i; j++)
                        res.append(c);
        return res.toString();
    }
}
