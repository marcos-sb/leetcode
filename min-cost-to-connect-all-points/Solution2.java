class Solution {
    public int minCostConnectPoints(int[][] points) {
        final var N = points.length;
        final var visited = new boolean[N];
        final var cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[0] = 0;
        var total = 0;
        for (var i = 0; i < N; ++i) {
            final var next = findNextNode(visited, cost);
            visited[next] = true;
            total += cost[next];
            for (var j = 0; j < N; ++j) {
                final var newD = d(points[next], points[j]);
                if (!visited[j] && newD < cost[j]) {
                    cost[j] = newD;
                }
            }
        }

        return total;
    }

    private int findNextNode(boolean[] visited, int[] cost) {
        var min = Integer.MAX_VALUE;
        var minIdx = -1;
        for (var i = 0; i < cost.length; ++i) {
            if (!visited[i] && cost[i] < min) {
                min = cost[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int d(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}
