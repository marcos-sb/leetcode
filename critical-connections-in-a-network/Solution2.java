class Solution {
    static class UEdge {
        int u, v;
        UEdge(int u, int v) {
            this.u = Math.min(u,v);
            this.v = Math.max(u,v);
        }
        List<Integer> toList() {
            return List.of(u,v);
        }
        @Override
        public boolean equals(Object obj) {
            // Don't take this shortcut in general
            final var that = (UEdge) obj;
            return this.u == that.u && this.v == that.v;
        }
        @Override
        public int hashCode() {
            return Objects.hash(u,v);
        }
    }
    
    private final List<List<Integer>> graph;
    private final Set<UEdge> critConns;
    private final List<Integer> rank;
    
    public Solution() {
        graph = new ArrayList<>();
        critConns = new HashSet<>();
        rank = new ArrayList<>();
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final var graph = makeGraph(n, connections);
        
        dfs(0, 1, -1);
        
        final List<List<Integer>> res = new ArrayList<>();
        for (var uedge : critConns)
            res.add(uedge.toList());
        
        return res;
    }
    
    private List<List<Integer>> makeGraph(int n, List<List<Integer>> conns) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            rank.add(0);
        }
        
        for (var conn : conns) {
            final var u = conn.get(0);
            final var v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
            critConns.add(new UEdge(u,v));
        }
        
        return graph;
    }
    
    private int dfs(int v, int discoveryRank, int u) {
        if (rank.get(v) > 0) return rank.get(v);
        rank.set(v, discoveryRank);
        
        int minRank = discoveryRank;
        for (var adj : graph.get(v)) {
            if (adj == u) continue;
            
            final var recRank = dfs(adj, discoveryRank + 1, v);
            
            if (recRank <= discoveryRank) {
                critConns.remove(new UEdge(v, adj));
            }
            
            minRank = Math.min(minRank, recRank);
        }
        
        return minRank;
    }
}
