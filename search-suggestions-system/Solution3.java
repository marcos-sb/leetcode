class Solution {
    private static class Node {
        Node[] next;
        boolean terminal;
        public Node() {
            next = new Node[26];
            terminal = false;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        final var trieHead = buildTrie(products);
        final var N = searchWord.length();

        final List<List<String>> res = new ArrayList<>(N);
        final var prefix = new StringBuilder(N);
        for (var c : searchWord.toCharArray()) {
            prefix.append(c);
            final var suggested = find(trieHead, prefix.toString(), 3);
            res.add(suggested);
        }

        return res;
    }

    private Node buildTrie(String[] products) {
        final var head = new Node();
        for (var product : products) {
            var curr = head;
            for (var c : product.toCharArray()) {
                if (curr.next[c-'a'] == null)
                    curr.next[c-'a'] = new Node();
                curr = curr.next[c-'a'];
            }
            curr.terminal = true;
        }
        return head;
    }

    private List<String> find(Node trieHead, String prefix, int k) {
        var curr = trieHead;
        for (var c : prefix.toCharArray()) {
            curr = curr.next[c-'a'];
            if (curr == null) {
                return List.of();
            }
        }

        final var res = new ArrayList<String>(k);
        findTerminal(curr, 3, new StringBuilder(prefix), res);

        return res;
    }

    private boolean findTerminal(Node trieNode, int k, StringBuilder prefix, List<String> res) {
        if (trieNode.terminal) {
            res.add(prefix.toString());
            if (res.size() == k) return false;
        }

        var curr = trieNode;
        for (var i = 0; i < 26; ++i) {
            if (curr.next[i] != null) {
                final var c = (char) ('a'+i);
                prefix.append(c);
                if (!findTerminal(curr.next[i], k, prefix, res)) return false;
                prefix.setLength(prefix.length()-1);
            }
        }

        return true;
    }
}
