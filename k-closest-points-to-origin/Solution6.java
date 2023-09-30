class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final var N = points.length;
        final var dist = new double[N];
        for (var i = 0; i < N; i++) // O(N)
            dist[i] = dto0(points[i]);

        final var kthDist = dist[quickSelect(dist, k-1, 0, N-1)]; // O(N)

        final var res = new int[k][];
        var j = 0;
        for (var i = 0; i < N && j < k; i++) { // O(N)
            if (dto0(points[i]) <= kthDist)
                res[j++] = points[i];
        }
        
        return res;
    }

    private static double dto0(int[] p) {
        final var p0 = p[0];
        final var p1 = p[1];
        return Math.sqrt(p0*p0 + p1*p1);
    }

    private static int quickSelect(double[] d, int k, int lo, int hi) {
        final var pivotI = ThreadLocalRandom.current().nextInt(lo, hi+1);
        swap(d, pivotI, hi);

        var j = lo;
        for (var i = lo; i < hi; i++) {
            if (d[i] <= d[hi]) swap(d, i, j++);
        }
        swap(d, hi, j);
        
        if (k < j) return quickSelect(d, k, lo, j-1);
        if (j < k) return quickSelect(d, k, j+1, hi);
        return j;
    }

    private static void swap(double[] d, int i, int j) {
        final var tmp = d[i];
        d[i] = d[j];
        d[j] = tmp;
    }
}
