class Solution {
    public boolean isBipartite(int[][] graph) {
        final var onSetA = new Boolean[graph.length];
        final var visited = new boolean[graph.length];
        for (var i = 0; i < graph.length; ++i) {
            if (!visited[i]) {
                onSetA[i] = true;
                if (!dfs(graph, i, onSetA, visited)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int v, Boolean[] onSetA, boolean[] visited) {
        if (visited[v]) return true;
        visited[v] = true;
        for (var u : graph[v]) {
            if (onSetA[u] != null && onSetA[v] == onSetA[u]) return false;
            onSetA[u] = !onSetA[v];
            if (!dfs(graph, u, onSetA, visited)) return false;
        }
        return true;
    }
}
