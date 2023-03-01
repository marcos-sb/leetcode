class Trie {
    class Node {
        final Node[] next;
        boolean terminal;
        Node() {
            next = new Node['z'-'a'+1];
            terminal = false;
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        var node = root;
        var i = 0;
        final var len = word.length();
        while (i < len) {
            final var idx = word.charAt(i)-'a';
            if (node.next[idx] == null)
                node.next[idx] = new Node();
            node = node.next[idx];
            i++;
        }
        node.terminal = true;
    }
    
    public boolean search(String word) {
        final var node = _search(word);
        return node != null && node.terminal;
    }

    private Node _search(String word) {
        var node = root;
        var i = 0;
        final var len = word.length();
        while (i < len && node != null)
            node = node.next[word.charAt(i++)-'a'];
        return node;
    }
    
    public boolean startsWith(String prefix) {
        return _search(prefix) != null;
    }
}
