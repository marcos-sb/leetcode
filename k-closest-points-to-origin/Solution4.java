class Solution {
    public int[][] kClosest(int[][] points, int k) {
        final var N = points.length;
        
        final var ds = new int[N];
        for (var i = 0; i < N; i++) ds[i] = d(points[i]);
        
        final var bound = quickSelect(ds, k-1, 0, N-1);
        final var res = new int[k][2];
        var i = 0;
        for (var p : points)
            if (d(p) <= bound) res[i++] = p;
        
        return res;
    }

    private static int d(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    private static int quickSelect(int[] d, int k, int lo, int hi) {
        final var p = ThreadLocalRandom.current().nextInt(lo, hi+1);
        swap(d, p, hi);
        
        var i = lo;
        for (var j = lo; j < hi; j++)
            if (d[j] < d[hi]) swap(d, i++, j);
        
        swap(d, i, hi);

        if (k < i) return quickSelect(d, k, lo, i-1);
        if (i < k) return quickSelect(d, k, i+1, hi);

        return d[i];
    }

    private static void swap(int[] points, int a, int b) {
        final var tmp = points[a];
        points[a] = points[b];
        points[b] = tmp;
    }
}
