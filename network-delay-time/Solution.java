class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        final var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
        final var minKDistance = new Integer[n];
        final var visited = new boolean[n];
        var visitedCount = 0;
        var maxDistance = 0;
        
        final var net = buildGraph(times, n);
        pq.offer(new int[]{k-1, 0});
        minKDistance[k-1] = 0;
        while (!pq.isEmpty() && visitedCount < n) {
            final var top = pq.poll();
            final var u = top[0];
            final var uw = top[1];
            if (!visited[u]) {
                for (var edge : net.get(u)) {
                    final var v = edge.get(0);
                    final var uvw = edge.get(1);
                    final var vw = uw+uvw;
                    if (minKDistance[v] == null || vw < minKDistance[v]) {
                        minKDistance[v] = vw;
                        pq.offer(new int[]{v,vw});
                    }
                }
                maxDistance = Math.max(maxDistance, uw);
                visited[u] = true;
                visitedCount++;
            }
        }
        
        return visitedCount == n ? maxDistance : -1;
    }
    
    private static List<List<List<Integer>>> buildGraph(int[][] times, int n) {
        final List<List<List<Integer>>> res = new ArrayList<>(n);
        for (var i = 0; i < n; i++) res.add(new ArrayList<>());
        for (var t : times) {
            final var u = t[0]-1;
            final var v = t[1]-1;
            final var w = t[2];
            res.get(u).add(List.of(v,w));
        }
        
        return res;
    }
}
