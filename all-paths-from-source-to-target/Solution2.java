class Solution {
    private boolean[] visited;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];
        final List<List<Integer>> res = new ArrayList<>();
        dfs(graph, 0, graph.length-1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[][] graph, int u, int target, List<Integer> currPath, List<List<Integer>> res) {
        if (u == target) {
            final var foundPath = new ArrayList<>(currPath);
            foundPath.add(u);
            res.add(foundPath);
            return;
        }

        if (visited[u]) return;

        currPath.add(u);
        visited[u] = true;
        for (var v : graph[u]) {
            dfs(graph, v, target, currPath, res);
        }
        currPath.removeLast();
        visited[u] = false;
    }
}
