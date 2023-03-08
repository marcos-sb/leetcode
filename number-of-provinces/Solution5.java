class Solution {
    public int findCircleNum(int[][] isConnected) {
        final var N = isConnected.length;
        final var visited = new boolean[N];
        var provinces = 0;
        for (var i = 0; i < N; i++)
            if (!visited[i])  {
                provinces++;
                dfs(isConnected, i, visited);
            }
        
        return provinces;
    }

    private static void dfs(int[][] connected, int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;

        for (var j = 0; j < connected.length; j++) {
            if (i == j) continue;
            final var nj = connected[i][j];
            if (nj == 1) dfs(connected, j, visited);
        }
    }
}
