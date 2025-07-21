class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        final List<Node>[] buckets = new List[26];
        for (var i = 0; i < 26; ++i) {
            buckets[i] = new ArrayList<>();
        }

        for (var word : words) {
            buckets[word.charAt(0)-'a'].add(new Node(word, 0));
        }

        var count = 0;

        for (var c : s.toCharArray()) {
            final var currBucket = buckets[c-'a'];
            buckets[c-'a'] = new ArrayList<>();

            for (var node : currBucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ++count;
                } else {
                    final var nextChar = node.word.charAt(node.index);
                    buckets[nextChar-'a'].add(node);
                }
            }
        }

        return count;
    }

    private static class Node {
        String word;
        int index;
        Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
