class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private boolean[] open;
    private int resIdx;

    public Solution() {
        resIdx = 0;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        open = new boolean[numCourses];
        for (var i = 0; i < numCourses; i++) // O(C)
            graph[i] = new ArrayList<>();
        for (var p : prerequisites) // O(P)
            graph[p[0]].add(p[1]);

        final var res = new int[numCourses];
        for (var u = 0; u < numCourses; u++) // O(C+P)
            if (!topological(u, res)) return new int[0];

        return res;
    }

    private boolean topological(int u, int[] res) { // O(C+P)
        if (visited[u]) return true;
        if (open[u]) return false;
        open[u] = true;
        for (var v : graph[u])
            if (!topological(v, res)) return false;
        visited[u] = true;
        open[u] = false;
        res[resIdx++] = u;
        return true;
    }
}
