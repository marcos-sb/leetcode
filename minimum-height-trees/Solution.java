class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        final var graph = buildGraph(edges, n);

        final var leaves = new LinkedList<Integer>();
        for (var u = 0; u < n; ++u) {
            if (graph[u].size() == 1) leaves.offer(u);
        }

        var remaining = n;
        while (2 < remaining) {
            var leaveCount = leaves.size();
            remaining -= leaveCount;
            while (0 < leaveCount--) {
                final var leaf = leaves.poll();
                final var leafParent = graph[leaf].iterator().next();
                graph[leafParent].remove(leaf);
                if (graph[leafParent].size() == 1)
                    leaves.offer(leafParent);
            }
        }

        return leaves;
    }

    private static Set<Integer>[] buildGraph(int[][] edges, int n) {
        final Set<Integer>[] graph = new HashSet[n];
        for (var i = 0; i < n; ++i) {
            graph[i] = new HashSet<>();
        }
        for (var uv : edges) {
            graph[uv[0]].add(uv[1]);
            graph[uv[1]].add(uv[0]);
        }
        return graph;
    }
}
