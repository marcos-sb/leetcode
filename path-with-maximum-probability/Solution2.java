class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int startNode, int endNode) {
        final var maxProb = new double[n];
        maxProb[startNode] = 1d;
        for (var i = 0; i < n; ++i) {
            var updated = false;
            for (var j = 0; j < edges.length; ++j) {
                final var e = edges[j];
                final var u = e[0];
                final var v = e[1];
                final var p = succProb[j];

                if (maxProb[v] < maxProb[u] * p) {
                    maxProb[v] = maxProb[u] * p;
                    updated = true;
                }

                if (maxProb[u] < maxProb[v] * p) {
                    maxProb[u] = maxProb[v] * p;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        return maxProb[endNode];
    }
}
