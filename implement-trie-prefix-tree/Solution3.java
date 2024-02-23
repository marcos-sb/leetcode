class Trie {
    private static class Node {
        final Node[] next;
        boolean terminal;
        
        Node() {
            next = new Node['z'-'a'+1];
            terminal = false;
        }
    }

    private Node head;

    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        final var cw = word.toCharArray();
        var curr = head;
        for (var c : cw) {
            if (curr.next[c-'a'] == null) curr.next[c-'a'] = new Node();
            curr = curr.next[c-'a'];
        }
        curr.terminal = true;
    }
    
    public boolean search(String word) {
        final var node = traverse(word);
        return node != null && node.terminal;
    }
    
    public boolean startsWith(String prefix) {
        final var node = traverse(prefix);
        return node != null;
    }

    private Node traverse(String word) {
        final var cw = word.toCharArray();
        var curr = head;
        for (var c : cw) {
            if (curr.next[c-'a'] == null) return null;
            curr = curr.next[c-'a'];
        }
        return curr;
    }
}
