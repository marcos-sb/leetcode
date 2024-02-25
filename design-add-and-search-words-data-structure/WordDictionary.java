class WordDictionary {

    static class Node {
        Map<Character, Node> next;
        boolean terminal;
        Node() {
            next = new HashMap<>();
            terminal = false;
        }
    }

    private final Node head;

    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node current = head;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            current = current.next.computeIfAbsent(c, __ -> new Node());
        }
        current.terminal = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(head, word.toCharArray(), 0);
    }

    private boolean search(Node current, char[] word, int i) {
        if (i >= word.length) return current.terminal;

        final char c = word[i];
        if (c == '.') {
            for (Node newCurrent : current.next.values()) {
                if (search(newCurrent, word, i+1)) return true;
            }
            return false;
        }

        if (!current.next.containsKey(c)) return false;

        return search(current.next.get(c), word, i+1);
    }
}
