class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final var g = buildGraph(prerequisites, numCourses);
        // visited:
        // 0: not visited
        // 1: open (traversing)
        // 2: closed (visited)
        final var visited = new int[numCourses];
        final var res = new int[numCourses];
        final var k = new int[]{0};
        for (var i = 0; i < numCourses; ++i) {
            if (!dfs(g, i, visited, res, k)) return new int[0];
        }
        return res;
    }

    private static List<Integer>[] buildGraph(int[][] reqs, int n) {
        final List<Integer>[] graph = new ArrayList[n];
        for (var i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        for (var uv : reqs) {
            graph[uv[0]].add(uv[1]);
        }
        return graph;
    }

    private static boolean dfs(List<Integer>[] graph, int u, int[] visited, int[] res, int[] k) {
        if (visited[u] == 1) return false;
        if (visited[u] == 2) return true;
        visited[u] = 1;
        for (var v : graph[u]) {
            if (!dfs(graph, v, visited, res, k)) return false;
        }
        visited[u] = 2;
        res[k[0]++] = u;
        return true;
    }
}
