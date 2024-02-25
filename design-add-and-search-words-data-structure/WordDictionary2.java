class WordDictionary {
    static class Node {
        final Map<Character, Node> next;
        boolean terminal;
        Node() {
            next = new HashMap<>(26);
            terminal = false;
        }
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        var curr = root;
        final var cw = word.toCharArray();
        for (var c : cw) {
            curr.next.computeIfAbsent(c, k -> new Node());
            curr = curr.next.get(c);
        }
        curr.terminal = true;
    }

    public boolean search(String word) {
        return search(root, 0, word);
    }

    private static boolean search(Node node, int from, String word) {
        final var W = word.length();
        if (from == W) return node.terminal;
        var curr = node;
        for (var i = from; i < W; i++) {
            final var c = word.charAt(i);
            if (c == '.') { // Try all, backtrack
                for (var next : curr.next.values())
                    if (search(next, i+1, word)) return true;
                return false;
            }
            if (!curr.next.containsKey(c)) return false;
            curr = curr.next.get(c);
        }
        return curr.terminal;
    }
}
