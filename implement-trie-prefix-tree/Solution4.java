class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        var curr = root;
        for (var c : word.toCharArray()) {
            if (curr.next[c-'a'] == null)
                curr.next[c-'a'] = new Node();
            curr = curr.next[c-'a'];
        }
        curr.terminal = true;
    }

    public boolean search(String word) {
        final var node = searchHelper(word);
        if (node == null) return false;
        return node.terminal;
    }

    public boolean startsWith(String prefix) {
        return searchHelper(prefix) != null;
    }

    private Node searchHelper(String word) {
        var curr = root;
        for (var c : word.toCharArray()) {
            if (curr.next[c-'a'] == null) {
                return null;
            }
            curr = curr.next[c-'a'];
        }
        return curr;
    }

    private static class Node {
        Node[] next;
        boolean terminal;
        Node() {
            next = new Node[26];
            terminal = false;
        }
    }
}
