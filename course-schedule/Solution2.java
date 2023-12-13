class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private boolean[] open;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        open = new boolean[numCourses];

        for (var i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();
        for (var p : prerequisites)
            graph[p[0]].add(p[1]);
        for (var u = 0; u < numCourses; u++)
            if (!topological(u)) return false;

        return true;
    }

    private boolean topological(int u) {
        if (visited[u]) return true;
        if (open[u]) return false;
        open[u] = true;
        for (var v : graph[u])
            if (!topological(v)) return false;
        visited[u] = true;
        open[u] = false;
        return true;
    }
}
