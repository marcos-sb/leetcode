class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final var graph = buildGraph(n, times); // O(E)
        final var visited = new boolean[n];
        final var minDistanceK = new int[n];
        Arrays.fill(minDistanceK, -1);
        final var minHeap = new PriorityQueue<int[]>((e1,e2) -> Integer.compare(e1[1], e2[1]));
        var visitedCount = 0;
        var time = 0;

        minHeap.offer(new int[]{k-1, time});
        while (!minHeap.isEmpty() && visitedCount < n) {
            final var curr = minHeap.poll();
            final var u = curr[0]; // current source node
            final var utime = curr[1]; // total time to reach 'u'
            if (!visited[u]) {
                if (graph[u] != null)
                    for (var e : graph[u]) { // O(E*log(V)), re: https://stackoverflow.com/a/59591926/1510676
                        final var v = e.getKey(); // destination node connected to 'u'
                        final var uvtime = e.getValue(); // u-(uvtime)-v
                        final var vtime = utime + uvtime; // total time to reach 'v'
                        if (minDistanceK[v] == -1 || uvtime < minDistanceK[v]) {
                            minDistanceK[v] = vtime;
                            minHeap.offer(new int[]{v, vtime});
                        }
                    }
                visited[u] = true;
                visitedCount++;
                time = Math.max(time, utime);
            }
        }

        return visitedCount < n ? -1 : time;
    }

    private static List<Pair<Integer,Integer>>[] buildGraph(int n, int[][] times) {
        final List<Pair<Integer,Integer>>[] res = new List[n];
        for (var t : times) {
            if (res[t[0]-1] == null)
                res[t[0]-1] = new ArrayList<>();
            res[t[0]-1].add(new Pair<>(t[1]-1, t[2]));
        }
        return res;
    }
}
