class Solution {
    static class Node {
        final Node[] next;
        boolean terminal;
        Node() {
            next = new Node['z'-'a'+1];
            terminal = false;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        final var trie = buildTrie(dictionary); // O(C), C: total chars in dictionary
        final var res = new StringBuilder();
        final var S = sentence.length();
        final var tokens = sentence.split(" "); // O(S)
        for (var t : tokens) { // O(len(tokens)*len(t)); O(T), T: total chars in tokens
            final var prefix = shorterPrefix(trie, t); // O(len(t))
            final var finalPrefix = prefix.equals("") ? t : prefix;
            res.append(finalPrefix).append(' ');
        }

        res.setLength(res.length()-1); // Remove extra ' '
        return res.toString();
    }

    private static Node buildTrie(List<String> words) { // O(c * w); ie, total chars in words
        final var root = new Node();
        for (var w : words) {
            final var cw = w.toCharArray();
            var curr = root;
            for (var c : cw) {
                if (curr.next[c-'a'] == null) curr.next[c-'a'] = new Node();
                curr = curr.next[c-'a'];
            }
            curr.terminal = true;
        }
        return root;
    }

    private static String shorterPrefix(Node root, String word) { // O(w)
        if (root == null) return "";
        var curr = root;
        final var cw = word.toCharArray();
        final var res = new StringBuilder();
        for (var c : cw) {
            if (curr.next[c-'a'] == null) return "";
            curr = curr.next[c-'a'];
            res.append(c);
            if (curr.terminal) break;
        }
        return res.toString();
    }
}
