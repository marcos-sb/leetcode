class Solution {
    private final Map<Character, List<Character>> graph;
    private final boolean[] visited;
    private final boolean[] open;

    public Solution() {
        graph = new HashMap<>();
        visited = new boolean['z'-'a'+1];
        open = new boolean['z'-'a'+1];
    }

    public String alienOrder(String[] words) {
        final var N = words.length;
        for (var w : words) { // O(N*W)
            final var W = w.length();
            for (var i = 0; i < W; i++) // O(W), W: max(len(w))
                graph.computeIfAbsent(w.charAt(i), _char -> new ArrayList<>());
        }

        for (var i = N-1; 0 < i; i--) { // O(N*W)
            final var w = words[i-1];
            final var s = words[i];
            final var W = w.length();
            final var S = s.length();
            if (S < W && w.startsWith(s)) return ""; // O(W), W: max(len(word))
            final var shorter = Math.min(W, S);
            for (var j = 0; j < shorter; j++) { // O(W)
                final var wc = w.charAt(j);
                final var sc = s.charAt(j);
                if (wc != sc) {
                    graph.get(sc).add(wc);
                    break;
                }
            }
        }

        final var res = new StringBuilder('z'-'a'+1);
        for (var u : graph.keySet()) {
            if (!topological(u, res)) return ""; // O(|V|+|E|) => O(26+26*26)
        }

        return res.toString();
    }

    private boolean topological(char u, StringBuilder res) {
        final var uIdx = u-'a';
        if (visited[uIdx]) return true;
        if (open[uIdx]) return false; // Cycle! => invalid order

        open[uIdx] = true;
        for (var v : graph.get(u))
            if (!topological(v, res)) return false;
        open[uIdx] = false;
        visited[uIdx] = true;
        res.append(u);

        return true;
    }
}
