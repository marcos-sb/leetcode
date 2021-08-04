class Solution {
    static class Node {
        boolean terminal;
        Map<Character, Node> next;
        Node() {
            terminal = false;
            next = new HashMap<>();
        }
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final var root = buildTrie(words);
        final var res = new ArrayList<String>();
        
        for (var w : words) {
            if (dfs(w, 0, root, 0)) res.add(w);
        }

        return res;
    }
    
    private static boolean dfs(String w, int i, Node root, int matches) {
        if (i == w.length()) return matches > 1;
        
        var curr = root;
        for (int j = i; j < w.length(); j++) {
            final var c = w.charAt(j);
            if (!curr.next.containsKey(c))
                return false;
            curr = curr.next.get(c);
            if (curr.terminal && dfs(w, j+1, root, matches+1)) {
                if (j+1 < w.length() && matches > 1) { // prune
                    final var nextC = w.charAt(j+1);
                    curr.next.remove(nextC);
                }
                return true;
            }
        }
        
        return false;
    }
    
    private static Node buildTrie(String[] words) {
        final var root = new Node();
        for (var w : words) {
            if (w.isEmpty()) continue;
            var curr = root;
            for (int i = 0; i < w.length(); i++) {
                final var c = w.charAt(i);
                curr = curr.next.computeIfAbsent(c, k -> new Node());
            }
            curr.terminal = true;
        }
        return root;
    }
}
