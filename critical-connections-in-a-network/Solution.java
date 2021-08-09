class Solution {
    static class UnionFind {
        int[] id;
        UnionFind(int sz) {
            id = new int[sz];
            for (int i = 0; i < sz; i++)
                id[i] = i;
        }
        int find(int a) {
            while (a != id[a]) {
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }
        boolean same(int a, int b) {
            return find(a) == find(b);
        }
        void union(int a, int b) {
            final var ida = find(a);
            final var idb = find(b);
            id[ida] = idb;
        }
        @Override
        public String toString() {
            return Arrays.toString(id);
        }
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        final var visited = new boolean[n];
        final var open = new boolean[n];
        final var uf = new UnionFind(n);
        final List<Integer> openStack = new ArrayList<>(n);
        final var graph = makeGraph(n, connections);
        
        for (int i = 0; i < graph.size(); i++) {
            incycle(graph, -1, i, uf, open, openStack, visited);
        }
        
        final List<List<Integer>> res = new ArrayList<>();
        for (var conn : connections)
            if (!uf.same(conn.get(0), conn.get(1))) res.add(conn);
        
        return res;
    }
    
    private static List<List<Integer>> makeGraph(int n, List<List<Integer>> conns) {
        final List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (var conn : conns) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        
        return graph;
    }
    
    private static void incycle(List<List<Integer>> graph, int prev, int cur, UnionFind uf, boolean[] open, List<Integer> openStack, boolean[] visited) {
        
        if (open[cur]) {
            int i = openStack.size()-1;
            while (openStack.get(i) != cur)
                uf.union(cur, openStack.get(i--));
            return;
        }
        
        if (visited[cur]) return;
        visited[cur] = true;
        open[cur] = true;
        openStack.add(cur);
        
        for (var adj : graph.get(cur)) {
            if (adj == prev) continue;
            incycle(graph, cur, adj, uf, open, openStack, visited);
        }
        openStack.remove(openStack.size()-1);
        open[cur] = false;
    }
}
