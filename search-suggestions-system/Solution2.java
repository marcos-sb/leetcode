import java.util.ArrayList;
import java.util.List;

class Solution {
    static class Node {
        final Node[] next;
        boolean terminal;
        Node() {
            next = new Node['z'-'a'+1];
            terminal = false;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        final var root = buildTrie(products); // O(products * max(len(product)))

        final List<List<String>> res = new ArrayList<>();
        final var casw = searchWord.toCharArray();
        final var S = casw.length;
        var node = root;
        for (var from = 0; from < S; from++) { // O(S)
            node = next(node, from, searchWord); // O(1)
            if (node == null) res.add(List.of());
            else {
                final var aux = new ArrayList<String>(3);
                final var suffix = new StringBuilder();
                suffixes(node, 3, suffix, aux);
                final var prefix = searchWord.substring(0, from+1);
                for (var i = 0; i < aux.size(); i++)
                    aux.set(i, prefix + aux.get(i));
                res.add(aux);
            }
        }

        return res;
    }

    private static Node buildTrie(String[] words) {
        final var root = new Node();
        for (var w : words) { // O(words * len(w))
            var curr = root;
            final var cw = w.toCharArray(); // O(len(w))
            for (var c : cw) { // O(cw)
                if (curr.next[c-'a'] == null) curr.next[c-'a'] = new Node();
                curr = curr.next[c-'a'];
            }
            curr.terminal = true;
        }
        return root;
    }

    private static Node next(Node node, int from, String word) { // O(1)
        if (node == null) return null;
        final var c = word.charAt(from);
        return node.next[c-'a'];
    }

    private static boolean suffixes(Node from, int k, StringBuilder suffix, List<String> res) {
        if (k == res.size()) return false;
        if (from.terminal) res.add(suffix.toString());
        for (var i = 0; i < 26; i++) {
            if (from.next[i] == null) continue;
            suffix.append((char)(i+'a'));
            if (!suffixes(from.next[i], k, suffix, res)) return false; // Prune when res.size() == k
            suffix.setLength(suffix.length()-1);
        }
        return true;
    }
}
