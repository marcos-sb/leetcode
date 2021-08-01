class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return n;
        
        final var adj = makeAdj(n, edges);
        final var visited = new boolean[n];
        final var q = new LinkedList<Integer>();
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            components++;
            visited[i] = true;
            q.offer(i);
            while (!q.isEmpty()) {
                final var curr = q.poll();
                for (var v : adj.get(curr)) {
                    if (visited[v]) continue;
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        
        return components;
    }
    
    private static List<List<Integer>> makeAdj(int n, int[][] edges) {
        final List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (var e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return adj;
    }
}
