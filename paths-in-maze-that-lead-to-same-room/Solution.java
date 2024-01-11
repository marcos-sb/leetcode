class Solution {
    private List<Integer>[] graph;
    private int count;

    public int numberOfPaths(int n, int[][] corridors) {
        this.graph = buildGraph(n, corridors);
        for (var i = 0; i < n; i++) dfs(i, i, 0);
        return count;
    }

    private static List<Integer>[] buildGraph(int n, int[][] edges) {
        final List<Integer>[] res = new List[n];
        for (var i = 0; i < n; i++) res[i] = new ArrayList<>();
        for (var e : edges) {
            res[e[0]-1].add(e[1]-1);
            res[e[1]-1].add(e[0]-1);
        }
        return res;
    }

    private void dfs(int start, int i, int depth) {
        if (3 == depth) {
            if (start == i) count++;
            return;
        }
        for (var nb : graph[i])
            if (i < nb || (nb < i && 2 == depth))
                dfs(start, nb, depth+1);
    }
}
