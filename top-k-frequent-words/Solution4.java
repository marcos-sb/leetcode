class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        final var n = words.length;
        final var counts = new HashMap<String, Integer>();

        var maxCount = 0;
        for (var word : words) {
            final var count = counts.getOrDefault(word, 0) + 1;
            counts.put(word, count);
            maxCount = Math.max(maxCount, count);
        }

        final List<String>[] buckets = new ArrayList[maxCount + 1];
        for (var entry : counts.entrySet()) {
            final var count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(entry.getKey());
        }

        final var res = new ArrayList<String>();
        for (var i = maxCount; 0 <= i && 0 < k; --i) {
            if (buckets[i] == null) {
                continue;
            }
            final var wordList = buckets[i];
            Collections.sort(wordList);
            for (var word : wordList) {
                if (k-- == 0) {
                    break;
                }
                res.add(word);
            }
        }

        return res;
    }
}
