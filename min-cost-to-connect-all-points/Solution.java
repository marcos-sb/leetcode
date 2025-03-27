class Solution {
    private boolean[] visited;
    private PriorityQueue<int[]> minHeap;
    private int N;
    private int left;

    public int minCostConnectPoints(int[][] points) {
        N = points.length;
        left = N;
        visited = new boolean[N];
        minHeap = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[2], b[2])
        );

        var cost = 0;

        visitNode(points, 0);
        while (0 < left) {
            final var edge = minHeap.poll();
            final var u = edge[0];
            final var v = edge[1];
            if (!visited[v]) {
                cost += edge[2];
                visitNode(points, v);
            }
        }

        return cost;
    }

    private void visitNode(int[][] points, int u) {
        if (visited[u]) return;
        visited[u] = true;
        for (var v = 0; v < N; ++v) {
            if (visited[v]) continue;
            minHeap.offer(new int[]{u, v, d(points[u], points[v])});
        }
        --left;
    }

    private static int d(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
