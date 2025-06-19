import java.util.NavigableSet;

class Solution {
    private static class Node {
        Node[] next;
        boolean terminal;
        NavigableSet<String> terminals;
        public Node() {
            next = new Node[26];
            terminal = false;
            terminals = new TreeSet<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        final var trieHead = buildTrie(products);
        final var N = searchWord.length();

        final List<List<String>> res = new ArrayList<>(N);
        var curr = trieHead;
        for (var c : searchWord.toCharArray()) {
            curr = curr.next[c-'a'];
            if (curr == null) {
                final var toAdd = N - res.size();
                for (var i = 0; i < toAdd; ++i) {
                    res.add(List.of());
                }
                break;
            }

            res.add(new ArrayList<>(curr.terminals));
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
                curr.terminals.add(product);
                if (3 < curr.terminals.size())
                    curr.terminals.pollLast();
            }
            curr.terminal = true;
        }
        return head;
    }
}
