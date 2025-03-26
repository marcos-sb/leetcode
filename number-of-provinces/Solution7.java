class Solution {
    private boolean[] visited;
    private int[][] graph;

    public int findCircleNum(int[][] isConnected) {
        graph = isConnected;
        final var N = isConnected.length;
        visited = new boolean[N];
        var count = 0;
        for (var city = 0; city < N; ++city) {
            if (!visited[city]) {
                dfs(city);
                ++count;
            }
        }
        return count;
    }

    private void dfs(int city) {
        visited[city] = true;
        for (var next = 0; next < graph.length; ++next) {
            if (!visited[next] && graph[city][next] == 1)
                dfs(next);
        }
    }
}
