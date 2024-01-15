class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;

    public boolean validTree(int n, int[][] edges) {
        graph = new List[n];
        for (var i = 0; i < n; i++)
            graph[i] = new ArrayList<>(n);
        for (var e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        visited = new boolean[n];

        if (!isTree(-1, 0)) return false;
        for (var b : visited)
            if (!b) return false;
        return true;
    }

    private boolean isTree(int from, int node) {
        if (visited[node]) return false;
        visited[node] = true;
        for (var n : graph[node]) {
            if (n == from) continue;
            if (!isTree(node, n)) return false;
        }
        return true;
    }
}
