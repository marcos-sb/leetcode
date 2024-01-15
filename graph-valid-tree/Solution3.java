class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private int visitedCount;

    // A graph is a valid tree iff
    // [1] There are exactly n-1 edges, and
    // [2] Is connected
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        
        graph = new List[n];
        for (var i = 0; i < n; i++)
            graph[i] = new ArrayList<>(n);
        for (var e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        visited = new boolean[n];
        visitedCount = 0;
        visit(-1, 0);

        return visitedCount == n;
    }

    private void visit(int from, int node) {
        if (visited[node]) return;
        visited[node] = true;
        visitedCount++;
        for (var n : graph[node]) {
            if (n == from) continue;
            visit(node, n);
        }
    }
}
