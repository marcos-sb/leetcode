class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        final var degree = new int[n];
        final List<Integer>[] graph = new ArrayList[n];
        for (var i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (var uv : edges) {
            graph[uv[0]].add(uv[1]);
            graph[uv[1]].add(uv[0]);
            ++degree[uv[0]];
            ++degree[uv[1]];
        }

        final var leaves = new LinkedList<Integer>();
        for (var u = 0; u < n; ++u) {
            if (degree[u] == 1) leaves.offer(u);
        }

        var remaining = n;
        while (2 < remaining) {
            var leaveCount = leaves.size();
            remaining -= leaveCount;
            while (0 < leaveCount--) {
                final var leaf = leaves.poll();
                for (var leafParent : graph[leaf]) {
                    if (--degree[leafParent] == 1) leaves.offer(leafParent);
                }
            }
        }

        return leaves;
    }
}
