class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var curr = root;
        for (var c : word.toCharArray()) {
            if (curr.next[c-'a'] == null)
                curr.next[c-'a'] = new TrieNode();
            curr = curr.next[c-'a'];
        }
        curr.terminal = true;
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), 0, root);
    }

    private boolean dfs(char[] word, int i, TrieNode node) {
        if (node == null) return false;
        var curr = node;
        for (var j = i; j < word.length; j++) {
            if (word[j] != '.') {
                if (curr.next[word[j]-'a'] == null) return false;
                curr = curr.next[word[j]-'a'];
            } else {
                for (var k = 0; k < 26; k++) {
                    if (dfs(word, j+1, curr.next[k])) return true;
                }
                return false;
            }
        }
        return curr.terminal;
    }

    private static class TrieNode {
        TrieNode[] next;
        boolean terminal;
        TrieNode() {
            next = new TrieNode[26];
            terminal = false;
        }
    }
}
