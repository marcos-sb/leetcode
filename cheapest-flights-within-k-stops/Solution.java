class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final var graph = buildGraph(flights, n);
        final var minStops = new int[n];
        final var minHeap = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[1],b[1])
        );

        Arrays.fill(minStops, Integer.MAX_VALUE);
        minHeap.offer(new int[]{src, 0, 0});
        minStops[src] = 0;
        while (!minHeap.isEmpty()) {
            final var curr = minHeap.poll();
            final var u = curr[0];
            final var costU = curr[1];
            final var stopsU = curr[2];
            if (dst == u) return costU;
            if (k < stopsU || minStops[u] < stopsU) continue;
            minStops[u] = stopsU;
            for (var edge : graph[u]) {
                final var v = edge[0];
                final var costV = costU + edge[1];
                final var stopsV = stopsU + 1;
                minHeap.offer(new int[]{v, costV, stopsV});
            }
        }

        return -1;
    }

    private static List<int[]>[] buildGraph(int[][] flights, int n) {
        final List<int[]>[] graph = new ArrayList[n];
        for (var i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        for (var edge : flights) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        return graph;
    }
}
