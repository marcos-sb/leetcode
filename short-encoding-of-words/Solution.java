class Solution {
    static class Node {
        boolean terminal;
        Map<Character, Node> next;
        Node() {
            this.terminal = false;
            this.next = new HashMap<>();
        }
    }
    
    public int minimumLengthEncoding(String[] words) {
        final var head = new Node();
        for (var w : words) // O(w*w.len) -> O(n), n total chars on input
            add(head, w, w.length()-1);

        final var suff = new ArrayList<String>();
        gatherLongestSuffixes(head, new StringBuilder(), suff);
        int encodingLength = suff.size();
        for (var s : suff) encodingLength += s.length();
        return encodingLength;
    }
    
    private static void add(Node node, String w, int i) { // O(w.len)
        if (i < 0) {
            node.terminal = true;
            return;
        }
        final var c = w.charAt(i);
        node.next.computeIfAbsent(c, k -> new Node());
        add(node.next.get(c), w, i-1);
    }
    
    private static boolean gatherLongestSuffixes(Node node, StringBuilder sb, List<String> res) { O(n + #suff*m)
        boolean longerSuffix = false;
        for (var entry : node.next.entrySet()) {
            sb.append(entry.getKey());
            final var nextNode = entry.getValue();
            longerSuffix = gatherLongestSuffixes(nextNode, sb, res);
            if (nextNode.terminal && !longerSuffix) { // O(longest suffixes)
                res.add(sb.toString()); // O(max word length)
                longerSuffix = true;
            }
            sb.setLength(sb.length()-1);
        }
        return longerSuffix;
    }
}
