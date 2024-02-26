class Solution {
    static class Node {
        final Node[] next;
        boolean terminal;
        Node() {
            next = new Node[10];
            terminal = false;
        }
    }

    public List<Integer> lexicalOrder(int n) {
        final var trie = buildTrie(n);
        final var res = new ArrayList<Integer>(n);
        dfs(trie, 0, res);
        return res;
    }

    private static Node buildTrie(int n) {
        final var root = new Node();
        for (var i = 1; i <= n; i++) {
            final var ca = String.valueOf(i).toCharArray();
            var curr = root;
            for (var c : ca) {
                if (curr.next[c-'0'] == null)
                    curr.next[c-'0'] = new Node();
                curr = curr.next[c-'0'];
            }
            curr.terminal = true;
        }
        return root;
    }

    private static void dfs(Node node, int n, List<Integer> res) {
        if (node.terminal) res.add(n);
        for (var i = 0; i <= 9; i++) {
            if (node.next[i] == null) continue;
            dfs(node.next[i], n*10+i, res);
        }
    }
}
