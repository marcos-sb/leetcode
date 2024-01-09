class Solution {
    private List<Pair<Integer,Integer>>[] graph;
    private int[] minTimeK;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.graph = buildGraph(n, times);
        this.minTimeK = new int[n];
        Arrays.fill(minTimeK, -1);
        
        final var q = new ArrayDeque<int[]>();
        minTimeK[k-1] = 0;
        q.offer(new int[]{k-1, 0});
        while (!q.isEmpty()) {
            final var currE = q.poll();
            final var u = currE[0];
            final var kutime = currE[1];
            if (graph[u] == null) continue;
            for (var e : graph[u]) {
                final var v = e.getKey();
                final var uvtime = e.getValue();
                final var kvtime = kutime + uvtime;
                if (minTimeK[v] != -1 && minTimeK[v] <= kvtime) continue;
                minTimeK[v] = kvtime;
                q.offer(new int[]{v, kvtime});
            }
        }

        var maxTime = 0;
        for (var t : minTimeK) {
            if (t == -1) return -1;
            maxTime = Math.max(maxTime, t);
        }
        return maxTime;
    }

    private static List<Pair<Integer,Integer>>[] buildGraph(int n, int[][] times) {
        final List<Pair<Integer,Integer>>[] res = new List[n];
        for (var t : times) {
            if (res[t[0]-1] == null)
                res[t[0]-1] = new ArrayList<>();
            res[t[0]-1].add(new Pair<>(t[1]-1, t[2]));
            Collections.sort(res[t[0]-1], (p1, p2) -> Integer.compare(p1.getValue(), p2.getValue()));
        }
        return res;
    }
}
