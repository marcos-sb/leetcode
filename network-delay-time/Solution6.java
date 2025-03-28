class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final var graph = buildGraph(times, n);
        final var visited = new boolean[n];
        final var minDist = new int[n];
        final var minHeap = new PriorityQueue<int[]>(
            (e1,e2) -> Integer.compare(e1[1],e2[1])
        );

        Arrays.fill(minDist, Integer.MAX_VALUE);
        --k; // graph is zero-indexed, k is one-indexed, times is one-indexed
        minDist[k] = 0;
        minHeap.offer(new int[]{k, 0});
        while (!minHeap.isEmpty()) {
            final var curr = minHeap.poll();
            if (visited[curr[0]]) continue;
            final var u = curr[0];
            visited[u] = true;
            final var distU = curr[1];

            for (var edge : graph[u]) {
                final var v = edge[0];
                final var distV = edge[1] + distU;
                if (!visited[v] && distV < minDist[v]) {
                    minDist[v] = distV;
                    minHeap.offer(new int[]{v, distV});
                }
            }
        }

        var max = 0;
        for (var md : minDist) {
            if (md == Integer.MAX_VALUE) return -1;
            max = Math.max(max, md);
        }

        return max;
    }

    private static List<int[]>[] buildGraph(int[][] times, int n) {
        final List<int[]>[] graph = new ArrayList[n];
        for (var i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (var edge : times) {
            graph[edge[0]-1].add(new int[]{edge[1]-1, edge[2]});
        }
        return graph;
    }
}
