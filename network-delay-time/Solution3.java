class Solution {
    private List<Pair<Integer,Integer>>[] graph;
    private int[] minTimeK;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.graph = buildGraph(n, times);
        this.minTimeK = new int[n];
        Arrays.fill(minTimeK, -1);
        
        dfs(k-1, 0);
        
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

    private void dfs(int node, int time) {
        if (minTimeK[node] != -1 && minTimeK[node] <= time) return;
        minTimeK[node] = time;
        if (graph[node] == null) return;
        for (var e : graph[node]) {
            final var v = e.getKey();
            final var etime = e.getValue();
            dfs(v, time + etime);
        }
    }
}
