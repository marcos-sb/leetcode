class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final var graph = buildGraph(times, n);
        final var visited = new boolean[n];
        final var minDist = new int[n];
        final var minHeap = new PriorityQueue<int[]>(
            (e1,e2) -> Integer.compare(e1[1],e2[1])
        );

        var left = n;
        var minTime = 0;
        --k; // graph is zero-indexed, k is one-indexed, times is one-indexed
        minDist[k] = 0;
        while (0 < --left) {
            visited[k] = true;
            for (var edge : graph[k]) {
                if (!visited[edge[0]]) {
                    minHeap.offer(new int[]{edge[0], edge[1] + minDist[k]});
                }
            }
            while (!minHeap.isEmpty() && visited[minHeap.peek()[0]]) {
                minHeap.poll();
            }
            if (minHeap.isEmpty()) return -1;
            final var next = minHeap.poll();
            k = next[0];
            minTime = next[1];
            minDist[k] = next[1];
        }

        return minTime;
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
