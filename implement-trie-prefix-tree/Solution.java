class Trie {
    static class Node {
        boolean terminal;
        Node[] next;
        Node() {
            next = new Node['z'-'a'+1];
            terminal = false;
        }
    }
    
    private Node head;
    
    /** Initialize your data structure here. */
    public Trie() {
        head = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null) return;
        
        Node curr = head;
        for (int i = 0; i < word.length(); i++) {
            final var c = word.charAt(i);
            final var idx = c-'a';
            if (curr.next[idx] == null) curr.next[idx] = new Node();
            curr = curr.next[idx];
        }
        curr.terminal = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) return false;
        final var node = find(word);
        return node == null ? false : node.terminal;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        final var node = find(prefix);
        return node != null;
    }
    
    private Node find(String word) {
        Node curr = head;
        for (int i = 0; i < word.length(); i++) {
            final var c = word.charAt(i);
            final var idx = c-'a';
            if (curr.next[idx] == null) return null;
            curr = curr.next[idx];
        }
        return curr;
    }
}
