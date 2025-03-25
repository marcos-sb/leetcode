class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        final var V = graph.length;
        final var visited = new int[V];
        for (var u = 0; u < V; ++u)
            dfs(graph, u, visited);

        final var res = new ArrayList<Integer>();
        for (var u = 0; u < V; ++u) {
            if (visited[u] == 1) continue;
            res.add(u);
        }

        return res;
    }

    private static boolean dfs(int[][] graph, int u, int[] visited) {
        if (1 == visited[u]) return false;
        if (2 == visited[u]) return true;
        visited[u] = 1;
        for (var v : graph[u]) {
            if(!dfs(graph, v, visited)) return false;
        }
        visited[u] = 2;
        return true;
    }
}
