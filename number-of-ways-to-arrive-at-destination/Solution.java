import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        // Build the adjacency list
        List<int[]>[] graph = buildGraph(n, roads);

        // Priority queue for Dijkstra's algorithm: (node, time)
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) ->
            Long.compare(a[1], b[1])
        );

        // Arrays to store the minimum time and number of ways
        long[] minTime = new long[n];
        long[] numMinTimeWays = new long[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        minTime[0] = 0;
        numMinTimeWays[0] = 1;
        minHeap.offer(new long[] { 0, 0 });

        while (!minHeap.isEmpty()) {
            long[] curr = minHeap.poll();
            int u = (int) curr[0];
            long timeU = curr[1];

            // Early termination: Dijkstra's satisfies that the moment we pop
            // a node from the heap it's the minimum time to get to that node
            if (u == n - 1) break;

            // Skip if the current time is greater than the known minimum time
            if (timeU > minTime[u]) continue;

            for (int[] edge : graph[u]) {
                int v = (int) edge[0];
                long timeUV = edge[1];
                long totalTime = timeU + timeUV;

                if (totalTime < minTime[v]) {
                    minTime[v] = totalTime;
                    numMinTimeWays[v] = numMinTimeWays[u];
                    minHeap.offer(new long[] { v, totalTime });
                } else if (totalTime == minTime[v]) {
                    numMinTimeWays[v] =
                        (numMinTimeWays[v] + numMinTimeWays[u]) % MOD;
                }
            }
        }

        return (int) (numMinTimeWays[n - 1] % MOD);
    }

    private List<int[]>[] buildGraph(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph[u].add(new int[] { v, time });
            graph[v].add(new int[] { u, time });
        }
        return graph;
    }
}
