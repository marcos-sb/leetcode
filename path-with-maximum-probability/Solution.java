class Solution {
    static record Edge(int u, double p) {};

    public double maxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode) {
        final var graph = buildGraph(edges, n, succProb);
        final var maxHeap = new PriorityQueue<Edge>((e1,e2) -> Double.compare(e2.p, e1.p));
        final var maxProb = new double[n];
        final var visited = new boolean[n];

        maxHeap.offer(new Edge(startNode, 1D));
        while (!maxHeap.isEmpty()) {
            final var curr = maxHeap.poll();
            visited[curr.u] = true;
            if (curr.u == endNode) return curr.p;
            for (var e : graph[curr.u]) {
                final var v = e.u;
                final var puv = e.p;
                if (visited[v]) continue;
                if (maxProb[v] < curr.p * puv) {
                    maxProb[v] = curr.p * puv;
                    maxHeap.offer(new Edge(v, maxProb[v]));
                }
            }
        }

        return 0D;
    }

    private static List<Edge>[] buildGraph(int[][] edges, int n, double[] prob) {
        final List<Edge>[] graph = new ArrayList[n];
        for (var i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        var i = 0;
        for (var edge : edges) {
            graph[edge[0]].add(new Edge(edge[1], prob[i]));
            graph[edge[1]].add(new Edge(edge[0], prob[i]));
            ++i;
        }
        return graph;
    }
}
