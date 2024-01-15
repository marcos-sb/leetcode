class Solution {
    private List<Integer>[] graph;
    private Set<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        graph = new List[n];
        for (var i = 0; i < n; i++)
            graph[i] = new ArrayList<>(n);
        for (var e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        visited = new HashSet<>();

        return isTree(-1, 0) && visited.size() == n;
    }

    private boolean isTree(int from, int node) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for (var n : graph[node]) {
            if (n == from) continue;
            if (!isTree(node, n)) return false;
        }
        return true;
    }
}
